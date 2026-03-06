package com.gpelipas.bookmarkwebapi.infrastructure.persistence.h2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.gpelipas.bookmarkwebapi.application.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.infrastructure.web.model.BookmarkWebDto;

@Component
public class BookmarkJpaEntityMapper {

    public BookmarkJpaEntity toDto(Bookmark bookmark) {
        BookmarkJpaEntity dto = new BookmarkJpaEntity();
        BeanUtils.copyProperties(bookmark, dto);

        return dto;
    }

    public Bookmark toDomain(BookmarkJpaEntity dto) {
        Bookmark domain = new Bookmark();
        BeanUtils.copyProperties(dto, domain);

        return domain;
    }

    public List<Bookmark> toDomainList(List<BookmarkJpaEntity> dtoList) {
        return dtoList.stream().map((dto) -> toDomain(dto)).collect(Collectors.toList());
    }

}
