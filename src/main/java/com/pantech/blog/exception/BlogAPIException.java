package com.pantech.blog.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Paul Nyishar
 * @Date 12/05/2022
 */
public class BlogAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogAPIException(String s, HttpStatus status, String message) {
        super(s);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
