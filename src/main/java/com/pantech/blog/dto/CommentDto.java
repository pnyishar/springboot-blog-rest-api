package com.pantech.blog.dto;

import lombok.Data;

/**
 * @author Paul Nyishar
 * @Date 11/05/2022
 */
@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
