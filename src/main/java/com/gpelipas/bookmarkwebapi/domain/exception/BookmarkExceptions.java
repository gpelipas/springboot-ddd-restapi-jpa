package com.gpelipas.bookmarkwebapi.domain.exception;

import java.util.Optional;

import com.gpelipas.bookmarkwebapi.domain.model.BookmarkId;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarkUrl;

/**
 * Domain Exception Factory
 */
public final class BookmarkExceptions {

    private BookmarkExceptions() {
    }

    // not found
    public static BookmarkOperationException notFound(BookmarkId id) {
        return new BookmarkOperationException(
                ErrorCode.BOOKMARK_NOT_FOUND,
                "Bookmark not found: " + id);
    }

    // archive violations
    public static BookmarkOperationException alreadyArchived(BookmarkId id) {
        return new BookmarkOperationException(
                ErrorCode.BOOKMARK_ALREADY_ARCHIVED,
                "Bookmark is already archived: " + id);
    }

    public static BookmarkOperationException notArchived(BookmarkId id) {
        return new BookmarkOperationException(
                ErrorCode.BOOKMARK_NOT_ARCHIVED,
                "Bookmark is not archived: " + id);
    }

    // validation
    public static BookmarkOperationException invalidUrl(String url) {
        return new BookmarkOperationException(
                ErrorCode.INVALID_URL_FORMAT,
                "Invalid bookmark URL: " + url);
    }

    public static BookmarkOperationException invalidId(String id) {
        return new BookmarkOperationException(
                ErrorCode.INVALID_ID_FORMAT,
                "Invalid bookmark ID format: " + id);
    }

    public static BookmarkOperationException invalidUserId(String userId) {
        return new BookmarkOperationException(
                ErrorCode.INVALID_USER_ID,
                "Invalid user id: " + userId);
    }

    public static BookmarkOperationException invalidTitle(String title) {
        return new BookmarkOperationException(
                ErrorCode.INVALID_TITLE,
                "Invalid Bookmark title: " + title);
    }

    public static BookmarkOperationException duplicateUrl(BookmarkUrl url) {
        return new BookmarkOperationException(
                ErrorCode.DUPLICATE_URL,
                "Bookmark URL already exists for this user: " + url);
    }

    public static BookmarkOperationException notYetPersisted() {
        return new BookmarkOperationException(
                ErrorCode.BOOKMARK_NOT_PERSISTED,
                "Bookmark ID not yet assigned — save the bookmark first");
    }

    public static BookmarkOperationException saveFailed(Optional<BookmarkId> id, Throwable cause) {
        return new BookmarkOperationException(
                ErrorCode.BOOKMARK_SAVE_FAILED,
                "Failed to save bookmark" + id.map(i -> " id=" + i).orElse(""),
                cause // preserve original cause for logging
        );
    }

    public static BookmarkOperationException saveFailed(String title, Throwable cause) {
        return new BookmarkOperationException(
                ErrorCode.BOOKMARK_SAVE_FAILED,
                "Failed to save bookmark" + title,
                cause // preserve original cause for logging
        );
    }

    public static BookmarkOperationException unexpected(Throwable cause) {
        return new BookmarkOperationException(
                ErrorCode.UNEXPECTED_ERROR,
                "An unexpected error occurred: " + cause.getMessage(),
                cause);
    }

}
