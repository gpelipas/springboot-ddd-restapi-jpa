package com.gpelipas.bookmarkwebapi.adapter.out.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkJpaRepository extends JpaRepository<BookmarkJpaEntity, String> {
    
    List<BookmarkJpaEntity> findByActiveTrue();

    List<BookmarkJpaEntity> findByTitleContainingAndActive(String name, boolean active);

}
