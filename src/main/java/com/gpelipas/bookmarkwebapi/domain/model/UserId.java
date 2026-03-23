package com.gpelipas.bookmarkwebapi.domain.model;

import com.gpelipas.bookmarkwebapi.domain.exception.BookmarkExceptions;

public record UserId(String value) {

    public UserId {
        if (value == null || value.isBlank()) {
            throw BookmarkExceptions.invalidUserId(value);
        }
    }

    public static UserId of(String value) {
        return new UserId(value);
    }
}
