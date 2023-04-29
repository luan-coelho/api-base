package com.baseapi.handle;

import com.baseapi.exception.ErrorResponse;
import org.jboss.resteasy.reactive.RestResponse;

class IllegalArgumentExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, ErrorResponse errorResponse) {
        errorResponse.setTitle("Validation Error");
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(RestResponse.StatusCode.BAD_REQUEST);
    }

    @Override
    public Class<? extends Exception> getExceptionType() {
        return IllegalArgumentException.class;
    }
}
