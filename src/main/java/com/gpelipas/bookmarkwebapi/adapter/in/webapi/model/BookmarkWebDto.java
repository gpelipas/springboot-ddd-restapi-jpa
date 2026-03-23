package com.gpelipas.bookmarkwebapi.adapter.in.webapi.model;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class BookmarkWebDto {
    
    private String id;
    private String title;
    private String description;
    private String url;
    private String ownerId;
    private ZonedDateTime dateSaved;
    private boolean active;    

}
