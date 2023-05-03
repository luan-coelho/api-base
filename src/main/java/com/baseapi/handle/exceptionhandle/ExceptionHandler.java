package com.baseapi.handle.exceptionhandle;

import com.baseapi.exception.ErrorResponse;

public interface ExceptionHandler {

    void handleException(Exception exception, ErrorResponse errorResponse);

    Class<? extends Exception> getExceptionType();

    String getTitle();

    int getStatus();
}
