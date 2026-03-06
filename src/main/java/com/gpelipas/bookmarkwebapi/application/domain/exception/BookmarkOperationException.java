package com.gpelipas.bookmarkwebapi.application.domain.exception;

/**
 * Bookmark Generic Exception 
 * 
 */
public class BookmarkOperationException extends RuntimeException {

    public BookmarkOperationException(String message) {
        super(message);
    }

    public BookmarkOperationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
