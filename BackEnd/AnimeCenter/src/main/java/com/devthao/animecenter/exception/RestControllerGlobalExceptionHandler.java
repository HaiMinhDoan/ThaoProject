package com.devthao.animecenter.exception;

import com.devthao.animecenter.models.response.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestControllerGlobalExceptionHandler {
    @ExceptionHandler({FailureActionException.class})
    public ResponseEntity<?> handleException(Exception ex, WebRequest request) {
        ResponseData responseData = new ResponseData();
        if (ex instanceof FailureActionException failureActionException) {
            responseData = ResponseData.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message(failureActionException.getMessage())
                    .data(failureActionException.getData())
                    .build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
}
