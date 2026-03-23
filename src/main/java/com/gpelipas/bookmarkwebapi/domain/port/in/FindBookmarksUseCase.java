package com.gpelipas.bookmarkwebapi.domain.port.in;

import java.util.List;

import com.gpelipas.bookmarkwebapi.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarksSearchCriteria;

public interface FindBookmarksUseCase {

    Bookmark find(String id);

    List<Bookmark> find(BookmarksSearchCriteria criteria);

}
