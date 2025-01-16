package com.devthao.animecenter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FailureActionException extends RuntimeException {
    private Object data;

    public FailureActionException(String message) {
        super(message);
    }
    public FailureActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
