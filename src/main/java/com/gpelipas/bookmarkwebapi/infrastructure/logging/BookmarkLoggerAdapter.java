package com.gpelipas.bookmarkwebapi.infrastructure.logging;

 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkLogger;

@Component
public class BookmarkLoggerAdapter implements BookmarkLogger {

    @Override
    public void logInfo(Class<?> clz, String message, Object... arg) {
        Logger logger = BookmarkLoggerAdapter.getLogger(clz); 
        logger.info(message, arg);
    }

    @Override
    public void logError(Class<?> clz, String message, Object... arg) {
        Logger logger = BookmarkLoggerAdapter.getLogger(clz); 
        logger.error(message, arg);
    }

    @Override
    public void logDebug(Class<?> clz, String message, Object... arg) {
        Logger logger = BookmarkLoggerAdapter.getLogger(clz); 
        logger.debug(message, arg);
    }
    
    static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
