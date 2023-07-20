package com.baseapi.handle;

import com.baseapi.exception.ProblemDetails;
import com.baseapi.handle.exceptionhandle.ExceptionHandler;
import io.vertx.core.http.HttpServerRequest;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.URISyntaxException;

@Provider
public class GlobalHandleException implements ExceptionMapper<Exception> {

    @Context
    HttpServerRequest request;

    @SneakyThrows
    @Override
    public Response toResponse(Exception exception) {
        ProblemDetails problemDetails = buildResponse(exception);
        return Response.status(problemDetails.getStatus()).entity(problemDetails).build();
    }

    private ProblemDetails buildResponse(Exception exception) throws URISyntaxException {
        ProblemDetails problemDetails = ProblemDetails.builder()
                .type(new URI(""))
                .instance(new URI(request.absoluteURI()))
                .build();

        ExceptionHandler handler = ExceptionHandlerRegistry.getHandler(exception.getClass());
        handler.handleException(exception, problemDetails);

        return problemDetails;
    }
}

