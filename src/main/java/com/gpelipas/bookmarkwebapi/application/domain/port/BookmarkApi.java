package com.gpelipas.bookmarkwebapi.application.domain.port;

import java.util.List;

import com.gpelipas.bookmarkwebapi.application.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.application.domain.model.BookmarkFilter;

public interface BookmarkApi {
    
    Bookmark findBookmark(String id);

    List<Bookmark> findBookmarks(BookmarkFilter filter);

    Bookmark addBookmark(Bookmark bookmark);

    void updateBookmark(Bookmark bookmark);

    void deleteBookmark(String id);

}
