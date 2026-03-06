package com.gpelipas.bookmarkwebapi.application.domain.model;

import java.time.ZonedDateTime;

/**
 * Bookmark Domain Entity
 * 
 */
public class Bookmark {

    private String id;
    private String name;
    private String url;
    private ZonedDateTime dateSaved;
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ZonedDateTime getDateSaved() {
        return dateSaved;
    }

    public void setDateSaved(ZonedDateTime dateSaved) {
        this.dateSaved = dateSaved;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Bookmark [id=" + id + ", name=" + name + ", url=" + url + ", dateSaved=" + dateSaved + ", active="
                + active + "]";
    }

}
