package com.gpelipas.bookmarkwebapi.infrastructure.web.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.gpelipas.bookmarkwebapi.application.domain.model.Bookmark;


@Component
public class BookmarkWebDtoMapper {
   
    public BookmarkWebDto toDto(Bookmark bookmark) {
        BookmarkWebDto dto = new BookmarkWebDto();
        BeanUtils.copyProperties(bookmark, dto);

        return dto;
    }

    public Bookmark toDomain(BookmarkWebDto dto) {
        Bookmark domain = new Bookmark();
        BeanUtils.copyProperties(dto, domain);

        return domain;
    }

    public List<BookmarkWebDto> toDtoList(List<Bookmark> domainList) {
        return domainList.stream().map((domain) -> toDto(domain)).collect(Collectors.toList());
    }

}
