package com.gpelipas.bookmarkwebapi.application.service;

import java.util.List;

import com.gpelipas.bookmarkwebapi.domain.exception.BookmarkExceptions;
import com.gpelipas.bookmarkwebapi.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarkId;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarksSearchCriteria;
import com.gpelipas.bookmarkwebapi.domain.port.in.CreateBookmarkUseCase;
import com.gpelipas.bookmarkwebapi.domain.port.in.DeleteBookmarkUseCase;
import com.gpelipas.bookmarkwebapi.domain.port.in.FindBookmarksUseCase;
import com.gpelipas.bookmarkwebapi.domain.port.in.UpdateBookmarkUseCase;
import com.gpelipas.bookmarkwebapi.domain.port.out.BookmarkStore;
import com.gpelipas.bookmarkwebapi.domain.support.BookmarkLogger;

/**
 * Bookmark Application Service
 * 
 */
public class BookmarkService
        implements FindBookmarksUseCase, CreateBookmarkUseCase, UpdateBookmarkUseCase, DeleteBookmarkUseCase {

    private BookmarkLogger bookmarkLogger;

    private BookmarkStore bookmarkStore;

    public BookmarkService(BookmarkLogger bookmarkLogger, BookmarkStore bookmarkStore) {
        this.bookmarkLogger = bookmarkLogger;
        this.bookmarkStore = bookmarkStore;
    }

    @Override
    public Bookmark find(String id) {

        bookmarkLogger.logInfo(this.getClass(), "Finding bookmark using id - {}", id);

        var bookmarkId = BookmarkId.of(id);

        return bookmarkStore.findById(bookmarkId)
                .orElseThrow(() -> BookmarkExceptions.notFound(bookmarkId));
    }

    @Override
    public List<Bookmark> find(BookmarksSearchCriteria criteria) {

        bookmarkLogger.logInfo(this.getClass(), "Finding bookmarks using filter - {}", criteria);

        var bookmarks = bookmarkStore.findAll(criteria);

        bookmarkLogger.logDebug(this.getClass(), "no. of bookmarks found - {}", bookmarks.size());

        return bookmarks;
    }

    @Override
    public Bookmark create(Bookmark bookmark) {
        bookmarkLogger.logDebug(this.getClass(), "Adding new bookmark {}", bookmark);

        bookmarkStore.save(bookmark);

        if (!bookmark.hasId()) {
            throw BookmarkExceptions.saveFailed(bookmark.title(), null);
        }

        bookmarkLogger.logDebug(this.getClass(), "successfully added - {}", bookmark);

        return bookmark;
    }

    @Override
    public Bookmark update(Bookmark bookmark) {
        bookmarkLogger.logDebug(this.getClass(), "Updating bookmark {}", bookmark);

        bookmarkStore.save(bookmark);

        bookmarkLogger.logDebug(this.getClass(), "successfully updated - {}", bookmark);

        return bookmark;
    }

    @Override
    public void delete(String id) {
        bookmarkLogger.logDebug(this.getClass(), "Deleting bookmark with id of {}", id);

        var bookmarkId = BookmarkId.of(id);

        bookmarkStore.delete(bookmarkId);

        bookmarkLogger.logDebug(this.getClass(), "successfully deleted bookmark - {}", id);
    }

}
