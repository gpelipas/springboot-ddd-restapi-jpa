package com.gpelipas.bookmarkwebapi.infrastructure.persistence.h2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gpelipas.bookmarkwebapi.application.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.application.domain.model.BookmarkFilter;
import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkStore;

import lombok.extern.slf4j.Slf4j;


/**
 * BookmarkStore adpater using Spring Data, JPA and H2DB 
 * 
 */
@Slf4j
@Component
public class BookmarkH2Store implements BookmarkStore {

    @Autowired
    private BookmarkJpaRepository bookmarkJpaRepository;

    @Autowired
    private BookmarkJpaEntityMapper bookmarkJpaEntityMapper;


    @Override
    public Bookmark find(String id) {
        var dto = bookmarkJpaRepository.findById(id).orElse(null);

        Bookmark domain = null; 
        if (dto != null) {
            domain = bookmarkJpaEntityMapper.toDomain(dto);
        }

        return domain; 
    }

    @Override
    public List<Bookmark> find(BookmarkFilter filter) {

        List<BookmarkJpaEntity> dtoList = null;
        if (filter == null || !StringUtils.hasText(filter.name())) {
            dtoList = bookmarkJpaRepository.findByActiveTrue();
        } else {
            dtoList = bookmarkJpaRepository.findByNameContainingAndActive(filter.name(), filter.active());
        }

        return bookmarkJpaEntityMapper.toDomainList(dtoList);
    }

    @Override
    public Bookmark add(Bookmark bookmark) {
        var dto = bookmarkJpaEntityMapper.toDto(bookmark);
        dto = bookmarkJpaRepository.saveAndFlush(dto);

        if (log.isDebugEnabled()) {
            log.debug("newly added entity - {}", dto);
        }

        return bookmarkJpaEntityMapper.toDomain(dto);
    }

    @Override
    public void update(Bookmark bookmark) {
        var dto = bookmarkJpaEntityMapper.toDto(bookmark);
        dto = bookmarkJpaRepository.saveAndFlush(dto);
    }

    @Override
    public void delete(String id) {
        var dto = bookmarkJpaRepository.findById(id).orElse(null);

        if (dto != null) {
            dto.setActive(false);
            bookmarkJpaRepository.flush();
        }

    }
    
}
