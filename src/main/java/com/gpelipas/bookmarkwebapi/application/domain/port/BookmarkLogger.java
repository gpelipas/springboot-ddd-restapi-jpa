package com.gpelipas.bookmarkwebapi.application.domain.port;


/**
 * Outbound Port for Bookmark domain logging 
 */
public interface BookmarkLogger {
   
    void logInfo(Class<?> clz, String message, Object... arg);

    void logError(Class<?> clz, String message, Object... arg);

    void logDebug(Class<?> clz, String message, Object... arg);

}
