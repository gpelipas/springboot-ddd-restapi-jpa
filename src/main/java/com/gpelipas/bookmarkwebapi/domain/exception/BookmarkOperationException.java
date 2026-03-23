package com.gpelipas.bookmarkwebapi.domain.exception;

/**
 * Bookmark Generic Exception
 * 
 */
public class BookmarkOperationException extends RuntimeException {

    private final ErrorCode errorCode;

    BookmarkOperationException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BookmarkOperationException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

}
