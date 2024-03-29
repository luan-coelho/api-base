package com.baseapi.handle.exceptionhandle;

import com.baseapi.exception.ProblemDetails;
import org.jboss.resteasy.reactive.RestResponse;

public class GenericExceptionHandler implements ExceptionHandler {

    @Override
    public Class<? extends Exception> getExceptionType() {
        return Exception.class;
    }

    @Override
    public String getTitle() {
        return "Internal Server Error";
    }

    @Override
    public int getStatus() {
        return RestResponse.StatusCode.INTERNAL_SERVER_ERROR;
    }
}
