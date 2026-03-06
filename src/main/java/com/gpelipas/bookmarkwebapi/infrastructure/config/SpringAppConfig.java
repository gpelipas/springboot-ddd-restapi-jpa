package com.gpelipas.bookmarkwebapi.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkApi;
import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkLogger;
import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkStore;
import com.gpelipas.bookmarkwebapi.infrastructure.common.BookmarkServiceBuilder;

@Configuration
public class SpringAppConfig {

    @Bean
    BookmarkApi BookmarkService(BookmarkLogger bookmarkLogger, BookmarkStore bookmarkStore) {
        var bookmarkService = BookmarkServiceBuilder.builder().bookmarkLogger(bookmarkLogger)
                .bookmarkStore(bookmarkStore).build();

        return bookmarkService;
    }

}
