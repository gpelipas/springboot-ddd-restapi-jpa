package com.gpelipas.bookmarkwebapi.infrastructure.persistence.h2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkJpaRepository extends JpaRepository<BookmarkJpaEntity, String> {
    
    List<BookmarkJpaEntity> findByActiveTrue();

    List<BookmarkJpaEntity> findByNameContainingAndActive(String name, boolean active);

}
