package com.gpelipas.bookmarkwebapi.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gpelipas.bookmarkwebapi.application.service.BookmarkService;
import com.gpelipas.bookmarkwebapi.domain.port.out.BookmarkStore;
import com.gpelipas.bookmarkwebapi.domain.support.BookmarkLogger;

@Configuration
public class SpringAppConfig {

    @Bean
    BookmarkService bookmarkService(BookmarkLogger bookmarkLogger, BookmarkStore bookmarkStore) {
        var bookmarkService = new BookmarkService(bookmarkLogger, bookmarkStore);

        return bookmarkService;
    }

}
