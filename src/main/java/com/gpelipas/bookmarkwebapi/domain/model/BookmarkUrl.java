package com.gpelipas.bookmarkwebapi.domain.model;

import com.gpelipas.bookmarkwebapi.domain.exception.BookmarkExceptions;

public record BookmarkUrl(String value) {
    public BookmarkUrl {
        if (value == null || value.isBlank()) {
            throw BookmarkExceptions.invalidUrl(value);
        }

        if (!value.startsWith("http://") && !value.startsWith("https://")) {
            throw BookmarkExceptions.invalidUrl(value);
        }
    }
}