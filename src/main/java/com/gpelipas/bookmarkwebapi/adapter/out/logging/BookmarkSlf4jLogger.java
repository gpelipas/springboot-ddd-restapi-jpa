package com.gpelipas.bookmarkwebapi.adapter.out.logging;

 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gpelipas.bookmarkwebapi.domain.support.BookmarkLogger;


/**
 * BookmarkLogger adapter using SLF4J 
 * 
 */
@Component
public class BookmarkSlf4jLogger implements BookmarkLogger {

    @Override
    public void logInfo(Class<?> clz, String message, Object... arg) {
        Logger logger = BookmarkSlf4jLogger.getLogger(clz); 

        if (logger.isInfoEnabled()) {
            logger.info(message, arg);
        }
    }

    @Override
    public void logError(Class<?> clz, String message, Object... arg) {
        Logger logger = BookmarkSlf4jLogger.getLogger(clz); 

        if (logger.isErrorEnabled()) {
            logger.error(message, arg);
        }
    }

    @Override
    public void logDebug(Class<?> clz, String message, Object... arg) {
        Logger logger = BookmarkSlf4jLogger.getLogger(clz); 

        if (logger.isDebugEnabled()) {
            logger.debug(message, arg);
        }
    }
    
    static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
