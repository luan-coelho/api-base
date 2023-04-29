package com.baseapi.handle;

import com.baseapi.exception.ErrorResponse;

interface ExceptionHandler {

    void handleException(Exception exception, ErrorResponse errorResponse);

    Class<? extends Exception> getExceptionType();
}
