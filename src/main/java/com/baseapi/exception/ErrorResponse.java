package com.baseapi.exception;

import lombok.*;

import java.net.URI;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
/*
Problem Detail
 */
public class ErrorResponse {

    private URI type;
    private String title;
    private int status;
    private String detail;
    private URI instance;
}