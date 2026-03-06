package com.gpelipas.bookmarkwebapi.infrastructure.web.model;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class BookmarkWebDto {
    
    private String id;
    private String name;
    private String url;
    private ZonedDateTime dateSaved;
    private boolean active;    

}
