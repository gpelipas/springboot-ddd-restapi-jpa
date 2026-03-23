package com.gpelipas.bookmarkwebapi.domain.port.in;

import com.gpelipas.bookmarkwebapi.domain.model.Bookmark;

public interface CreateBookmarkUseCase {
    Bookmark create(Bookmark bookmark);
}
