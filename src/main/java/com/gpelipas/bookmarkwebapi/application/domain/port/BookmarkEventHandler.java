package com.gpelipas.bookmarkwebapi.application.domain.port;

import com.gpelipas.bookmarkwebapi.application.domain.model.Bookmark;

/**
 * Outbound Port for Bookmark event handling
 */
public interface BookmarkEventHandler {
    
    void publish(Event event);

    Event consume();

    public static class Event {
        public String name;
        public Bookmark payload;
    }

}
