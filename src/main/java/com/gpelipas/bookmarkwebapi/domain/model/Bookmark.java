package com.gpelipas.bookmarkwebapi.domain.model;

import java.time.ZonedDateTime;
import java.util.Optional;

import com.gpelipas.bookmarkwebapi.domain.exception.BookmarkExceptions;

/**
 * Bookmark Domain Aggregate
 * 
 * Note: no setters — all mutation goes through behaviour methods
 * 
 */
public class Bookmark {

    private BookmarkId id;
    private BookmarkUrl url;
    private String title;
    private String description;
    private UserId owner;
    private ZonedDateTime dateSaved;
    private boolean active;

    private Bookmark(BookmarkId id,
            BookmarkUrl url,
            String title,
            String description,
            UserId owner,
            boolean active,
            ZonedDateTime dateSaved) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.active = active;
        this.dateSaved = dateSaved;
    }

    public static Bookmark create(BookmarkUrl url,
            UserId owner,
            String title,
            String description) {

        if (title == null || title.isBlank()) {
            throw BookmarkExceptions.invalidTitle(title);
        }

        return new Bookmark(null,
                url,
                title,
                description,
                owner,
                true,
                null);
    }

    public static Bookmark create(String url,
            String ownerId,
            String title,
            String description) {

        if (title == null || title.isBlank()) {
            throw BookmarkExceptions.invalidTitle(title);
        }

        return new Bookmark(null,
                new BookmarkUrl(url),
                title,
                description,
                new UserId(ownerId),
                true,
                null);
    }

    public static Bookmark create(String id,
            String url,
            String ownerId,
            String title,
            String description,
            boolean active,
            ZonedDateTime dataSaved) {

        if (title == null || title.isBlank()) {
            throw BookmarkExceptions.invalidTitle(title);
        }

        BookmarkId bookmarkId = id != null? BookmarkId.of(id) : null;

        return new Bookmark(bookmarkId,
                new BookmarkUrl(url),
                title,
                description,
                new UserId(ownerId),
                active,
                dataSaved);
    }

    public BookmarkId requireId() {
        return Optional.ofNullable(this.id)
                .orElseThrow(BookmarkExceptions::notYetPersisted);
    }

    public void assignId(BookmarkId id) {
        if (!hasId()) {
            this.id = id; // silently ignore if already assigned
        }
    }

    public boolean hasId() {
        return this.id != null;
    }

    public Optional<BookmarkId> id() {
        return Optional.ofNullable(this.id);
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public Optional<BookmarkUrl> url() {
        return Optional.ofNullable(this.url);
    }

    public Optional<UserId> owner() {
        return Optional.ofNullable(this.owner);
    }

    public void changeUrl(BookmarkUrl newUrl) {
        this.url = newUrl;
    }

    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }

    public void changeDescription(String newDescString) {
        this.description = newDescString;
    }

    public void changeOwner(UserId newOwner) {
        this.owner = newOwner;
    }

    public boolean isActive() {
        return this.active;
    }

    public void deactivate() {
        this.active = false;
    }

    public ZonedDateTime dateSaved() {
        return this.dateSaved;
    }

}
