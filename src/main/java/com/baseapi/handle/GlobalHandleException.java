package com.baseapi.handle;

import com.baseapi.exception.ErrorResponse;
import io.vertx.core.http.HttpServerRequest;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.SneakyThrows;
import org.jboss.resteasy.reactive.RestResponse;

import java.net.URI;
import java.net.URISyntaxException;

@Provider
public class GlobalHandleException implements ExceptionMapper<Exception> {

    @Context
    HttpServerRequest request;

    @SneakyThrows
    @Override
    public Response toResponse(Exception exception) {
        ErrorResponse errorResponse = buildResponse(exception);
        return Response.status(errorResponse.getStatus()).entity(errorResponse).build();
    }

    private ErrorResponse buildResponse(Exception exception) throws URISyntaxException {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .type(new URI(""))
                .instance(new URI(request.absoluteURI()))
                .build();

        if (exception instanceof IllegalArgumentException) {
            handleException(((IllegalArgumentException) exception), errorResponse);
        } else if (exception instanceof NotFoundException) {
            handleException(((NotFoundException) exception), errorResponse);
        } else {
            handleException(exception, errorResponse);
        }

        return errorResponse;
    }

    private void handleException(IllegalArgumentException exception, ErrorResponse errorResponse) {
        errorResponse.setTitle("Validation Error");
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(RestResponse.StatusCode.BAD_REQUEST);
    }

    private void handleException(NotFoundException exception, ErrorResponse errorResponse) {
        errorResponse.setTitle("Validation Error");
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(RestResponse.StatusCode.BAD_REQUEST);
    }

    private void handleException(Exception exception, ErrorResponse errorResponse) {
        errorResponse.setTitle("Internal Server Error");
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(RestResponse.StatusCode.INTERNAL_SERVER_ERROR);
    }
}

