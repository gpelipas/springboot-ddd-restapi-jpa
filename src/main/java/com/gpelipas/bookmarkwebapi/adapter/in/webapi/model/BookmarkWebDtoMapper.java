package com.gpelipas.bookmarkwebapi.adapter.in.webapi.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gpelipas.bookmarkwebapi.domain.model.Bookmark;



@Component
public class BookmarkWebDtoMapper {
   
    public BookmarkWebDto toDto(Bookmark domain) {
        BookmarkWebDto dto = new BookmarkWebDto();

        domain.id().ifPresent(o -> dto.setId(o.toString()));
        domain.url().ifPresent(o -> dto.setUrl(o.value()));
        domain.owner().ifPresent(o -> dto.setOwnerId(o.value()));

        dto.setTitle(domain.title());
        dto.setDescription(domain.description());
        dto.setActive(domain.isActive());
        dto.setDateSaved(domain.dateSaved());

        return dto;
    }

    public Bookmark toDomain(BookmarkWebDto dto) {
        Bookmark domain = Bookmark.create(dto.getId(), dto.getUrl(), dto.getOwnerId(), dto.getTitle(), dto.getDescription(), dto.isActive(), dto.getDateSaved());

        return domain;
    }

    public List<BookmarkWebDto> toDtoList(List<Bookmark> domainList) {
        return domainList.stream().map((domain) -> toDto(domain)).collect(Collectors.toList());
    }

}
