package com.pantech.blog.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Paul Nyishar
 * @Date 11/05/2022
 */
@Data
public class CommentDto {
    private long id;

    // name should not be null or empty
    @NotEmpty(message = "name should not be null or empty")
    private String name;

    // email should not be null or empty
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;

    // comment body should not be null or empty
    // comment body must be a minimum of 10 characters
    @NotEmpty(message = "comment body should not be null or empty")
    @Size(min = 10, message = "comment body should be minimum of 10 characters")
    private String body;
}
