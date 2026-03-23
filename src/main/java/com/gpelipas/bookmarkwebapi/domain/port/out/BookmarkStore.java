package com.gpelipas.bookmarkwebapi.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.gpelipas.bookmarkwebapi.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarkId;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarksSearchCriteria;

/**
 * Outbound Port for Bookmark domain storage 
 */
public interface BookmarkStore {

    void save(Bookmark bookmark);

    void delete(BookmarkId id);

    Optional<Bookmark> findById(BookmarkId id);
    
    List<Bookmark> findAll(BookmarksSearchCriteria criteria);    

}
