package com.priceengine.dto.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonError {

    private String errorCode;

    private String errorDesc;

    private String customErrorMessage;

    @Override
    public String toString() {
        return "CommonError{" +
                "errorCode='" + errorCode + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", customErrorMessage='" + customErrorMessage + '\'' +
                '}';
    }
}
