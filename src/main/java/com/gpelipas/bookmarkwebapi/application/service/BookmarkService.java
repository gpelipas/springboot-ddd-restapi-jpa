package com.gpelipas.bookmarkwebapi.application.service;

import java.util.List;

import com.gpelipas.bookmarkwebapi.application.domain.exception.BookmarkOperationException;
import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkApi;
import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkLogger;
import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkStore;
import com.gpelipas.bookmarkwebapi.application.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.application.domain.model.BookmarkFilter;

/**
 * Bookmark Application Service
 * 
 */
public class BookmarkService implements BookmarkApi {

    private BookmarkLogger bookmarkLogger;

    private BookmarkStore bookmarkStore;

    @Override
    public Bookmark findBookmark(String id) {

        bookmarkLogger.logInfo(this.getClass(), "Finding bookmark using id - {}", id);

        Bookmark bookmark = bookmarkStore.find(id);

        if (bookmark == null) {
            throw new BookmarkOperationException("Unable to find bookmark using id of " + id);
        }

        return bookmark;
    }

    @Override
    public List<Bookmark> findBookmarks(BookmarkFilter filter) {

        bookmarkLogger.logInfo(this.getClass(), "Finding bookmarks using filter - {}", filter);

        var bookmarks = bookmarkStore.find(filter);

        bookmarkLogger.logDebug(this.getClass(), "no. of bookmarks found - {}", bookmarks.size());

        return bookmarks;
    }

    @Override
    public Bookmark addBookmark(Bookmark bookmark) {
        bookmarkLogger.logDebug(this.getClass(), "Adding new bookmark {}", bookmark);


        Bookmark addedBookmark = bookmarkStore.add(bookmark);

        if (addedBookmark == null) {
            final String error = String.format("Failed adding new bookmark - name: %s", bookmark.getName());
            throw new BookmarkOperationException(error);
        }

        bookmarkLogger.logDebug(this.getClass(), "successfully added - {}", addedBookmark);

        return addedBookmark;
    }

    @Override
    public Bookmark updateBookmark(Bookmark bookmark) {
        bookmarkLogger.logDebug(this.getClass(), "Updating bookmark {}", bookmark);

        Bookmark updatedBookmark = bookmarkStore.add(bookmark);

        if (updatedBookmark == null) {
            final String error = String.format("Failed updating bookmark - name: %s", bookmark.getName());
            throw new BookmarkOperationException(error);
        }

        bookmarkLogger.logDebug(this.getClass(), "successfully updated - {}", updatedBookmark);

        return updatedBookmark;
    }

    @Override
    public void deleteBookmark(String id) {
        bookmarkLogger.logDebug(this.getClass(), "Deleting bookmark with id of {}", id);

        bookmarkStore.delete(id);

        bookmarkLogger.logDebug(this.getClass(), "deletion completed for bookmark - {}", id);
    }

    public void setBookmarkStore(BookmarkStore bookmarkStore) {
        this.bookmarkStore = bookmarkStore;
    }

    public void setBookmarkLogger(BookmarkLogger bookmarkLogger) {
        this.bookmarkLogger = bookmarkLogger;
    }

}
