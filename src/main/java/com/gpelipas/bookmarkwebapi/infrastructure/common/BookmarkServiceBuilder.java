package com.gpelipas.bookmarkwebapi.infrastructure.common;

import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkLogger;
import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkStore;
import com.gpelipas.bookmarkwebapi.application.service.BookmarkService;

import lombok.Builder;

public class BookmarkServiceBuilder extends BookmarkService {
    
    @Builder
    public BookmarkServiceBuilder(BookmarkStore bookmarkStore, BookmarkLogger bookmarkLogger) {
        super();
        setBookmarkLogger(bookmarkLogger);
        setBookmarkStore(bookmarkStore);
    }

}
