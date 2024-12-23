package com.fastcampus.programming.dmaker.exception;

import lombok.Getter;

public class DMakerException extends RuntimeException{
    private DMakerErrorCode dmakerErrorCode;
    private String detailMessage;

    public DMakerException(DMakerErrorCode errorCode){
        super(errorCode.getMessage());
        this.dmakerErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    public DMakerException(DMakerErrorCode errorCode, String detailMessage){
        super(errorCode.getMessage());
        this.dmakerErrorCode = errorCode;
        this.detailMessage = detailMessage;
    }
}
