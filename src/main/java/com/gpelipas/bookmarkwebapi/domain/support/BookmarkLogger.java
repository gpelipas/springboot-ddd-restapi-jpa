package com.gpelipas.bookmarkwebapi.domain.support;


/**
 * Outbound Port for Bookmark domain logging 
 */
public interface BookmarkLogger {
   
    void logInfo(Class<?> caller, String message, Object... arg);

    void logError(Class<?> caller, String message, Object... arg);

    void logDebug(Class<?> caller, String message, Object... arg);

}
