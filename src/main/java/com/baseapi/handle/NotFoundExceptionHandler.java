package com.baseapi.handle;

import com.baseapi.exception.ErrorResponse;
import jakarta.ws.rs.NotFoundException;
import org.jboss.resteasy.reactive.RestResponse;

class NotFoundExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, ErrorResponse errorResponse) {
        errorResponse.setTitle("Not Found");
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(RestResponse.StatusCode.NOT_FOUND);
    }

    @Override
    public Class<? extends Exception> getExceptionType() {
        return NotFoundException.class;
    }
}
