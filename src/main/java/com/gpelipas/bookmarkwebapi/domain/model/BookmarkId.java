package com.gpelipas.bookmarkwebapi.domain.model;

import java.util.UUID;

import com.gpelipas.bookmarkwebapi.domain.exception.BookmarkExceptions;

public record BookmarkId(UUID value) {

    public BookmarkId {
        if (value == null) {
            throw BookmarkExceptions.invalidId(null);
        }
    }

    public static BookmarkId generate() {
        return new BookmarkId(UUID.randomUUID());
    }

    public static BookmarkId of(UUID value) {
        return new BookmarkId(value);
    }
    
    public static BookmarkId of(String value) {
        try {
            return new BookmarkId(UUID.fromString(value));
        } catch (IllegalArgumentException e) {
            throw BookmarkExceptions.invalidId(value);
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
