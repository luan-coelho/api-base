package com.baseapi.handle;

import com.baseapi.exception.ErrorResponse;
import org.jboss.resteasy.reactive.RestResponse;

class GeneralExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, ErrorResponse errorResponse) {
        errorResponse.setTitle("Internal Server Error");
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(RestResponse.StatusCode.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Class<? extends Exception> getExceptionType() {
        return Exception.class;
    }
}
