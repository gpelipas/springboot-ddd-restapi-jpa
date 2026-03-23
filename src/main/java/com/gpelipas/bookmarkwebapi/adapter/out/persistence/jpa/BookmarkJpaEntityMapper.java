package com.gpelipas.bookmarkwebapi.adapter.out.persistence.jpa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gpelipas.bookmarkwebapi.domain.model.Bookmark;

@Component
public class BookmarkJpaEntityMapper {

    /**
     * Converts Bookmark domain model to JPA dto
     * 
     * @param domain
     * @return dto
     */
    public BookmarkJpaEntity toDto(Bookmark domain) {
        BookmarkJpaEntity dto = new BookmarkJpaEntity();

        domain.id().ifPresent(o -> dto.setId(o.toString()));
        domain.url().ifPresent(o -> dto.setUrl(o.value()));
        domain.owner().ifPresent(o -> dto.setOwnerId(o.value()));

        dto.setTitle(domain.title());
        dto.setDescription(domain.description());
        dto.setActive(domain.isActive());
        dto.setDateSaved(domain.dateSaved());

        return dto;
    }

    /**
     * Converts dto to Bookmark domain
     * 
     * @param dto
     * @return domain
     */
    public Bookmark toDomain(BookmarkJpaEntity dto) {
        Bookmark domain = Bookmark.create(dto.getId(), dto.getUrl(), dto.getOwnerId(), dto.getTitle(), dto.getDescription(), dto.isActive(), dto.getDateSaved());

        return domain;
    }

    /**
     * Converts list of dto to list of domain
     * 
     * @param dtoList
     * @return domain list
     */
    public List<Bookmark> toDomainList(List<BookmarkJpaEntity> dtoList) {
        return dtoList.stream().map((dto) -> toDomain(dto)).collect(Collectors.toList());
    }

}
