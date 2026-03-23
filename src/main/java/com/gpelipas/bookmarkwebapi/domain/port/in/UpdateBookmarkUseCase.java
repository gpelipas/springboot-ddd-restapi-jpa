package com.gpelipas.bookmarkwebapi.domain.port.in;

import com.gpelipas.bookmarkwebapi.domain.model.Bookmark;

public interface UpdateBookmarkUseCase {

    Bookmark update(Bookmark bookmark);

}
