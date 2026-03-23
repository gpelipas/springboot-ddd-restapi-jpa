package com.gpelipas.bookmarkwebapi.adapter.out.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gpelipas.bookmarkwebapi.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarkId;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarksSearchCriteria;
import com.gpelipas.bookmarkwebapi.domain.port.out.BookmarkStore;

import lombok.extern.slf4j.Slf4j;


/**
 * BookmarkStore adpater using Spring Data, JPA and H2DB 
 * 
 */
@Slf4j
@Component
public class BookmarkJpaStore implements BookmarkStore {

    @Autowired
    private BookmarkJpaRepository bookmarkJpaRepository;

    @Autowired
    private BookmarkJpaEntityMapper bookmarkJpaEntityMapper;


    @Override
    public Optional<Bookmark> findById(BookmarkId id) {
        var dto = bookmarkJpaRepository.findById(id.toString());

        Optional<Bookmark> out = dto.map(o -> bookmarkJpaEntityMapper.toDomain(o));

        return out;
    }

    @Override
    public List<Bookmark> findAll(BookmarksSearchCriteria filter) {

        List<BookmarkJpaEntity> dtoList = null;
        if (filter == null || !StringUtils.hasText(filter.name())) {
            dtoList = bookmarkJpaRepository.findByActiveTrue();
        } else {
            dtoList = bookmarkJpaRepository.findByTitleContainingAndActive(filter.name(), filter.active());
        }

        return bookmarkJpaEntityMapper.toDomainList(dtoList);
    }

    @Override
    public void save(Bookmark bookmark) {
        var dto = bookmarkJpaEntityMapper.toDto(bookmark);
        dto = bookmarkJpaRepository.saveAndFlush(dto);

        // capture hibernate auto-generated id
        bookmark.assignId(BookmarkId.of(dto.getId()));

        if (log.isDebugEnabled()) {
            log.debug("succesfully saved - {}", dto);
        }
    }

    @Override
    public void delete(BookmarkId id) {
        var dto = bookmarkJpaRepository.findById(id.toString());

        dto.ifPresent(o -> {
            o.setActive(false);
            bookmarkJpaRepository.flush();

            if (log.isDebugEnabled()) {
                log.debug("succesfully marked as deleted - {}", dto);
            }            
        });

    }
    
}
