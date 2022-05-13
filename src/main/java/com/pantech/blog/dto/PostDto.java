package com.pantech.blog.dto;

import lombok.Data;

import java.util.Set;

/**
 * @author Paul Nyishar
 * @Date 09/05/2022
 */

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;
}
