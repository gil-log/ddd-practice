package com.huvenet.practice.ddd.core.presentation;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class BaseResponse {

    private boolean success;
    private Integer code;
    private String message;

    protected BaseResponse() {

    }

    @Builder(
        builderMethodName = "initBySuccess"
    )
    private BaseResponse(boolean success) {
        this.success = success;
    }

    @Builder(
        builderMethodName = "initByMessage"
    )
    private BaseResponse(String message) {
        this.message = message;
    }

    protected BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
