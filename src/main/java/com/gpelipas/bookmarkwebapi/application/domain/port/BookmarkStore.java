package com.gpelipas.bookmarkwebapi.application.domain.port;

import java.util.List;

import com.gpelipas.bookmarkwebapi.application.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.application.domain.model.BookmarkFilter;

public interface BookmarkStore {

    Bookmark find(String id);

    List<Bookmark> find(BookmarkFilter filter);

    Bookmark add(Bookmark bookmark);

    void update(Bookmark bookmark);

    void delete(String id);

}
