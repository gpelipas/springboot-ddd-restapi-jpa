package com.gpelipas.bookmarkwebapi.adapter.in.webapi.model;

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