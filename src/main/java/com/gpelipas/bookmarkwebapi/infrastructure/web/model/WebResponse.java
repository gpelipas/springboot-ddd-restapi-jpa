package com.gpelipas.bookmarkwebapi.infrastructure.web.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WebResponse {

    private STATUS status;
    private String message;
    private Object payload;


    public enum STATUS {
        SUCCESS,
        ERROR,
        FAILED
    }

}
