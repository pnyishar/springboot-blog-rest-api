package com.pantech.blog.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Paul Nyishar
 * @Date 09/05/2022
 */

@Data
public class PostDto {
    private Long id;

    // title should not be null or empty
    // title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    // title should not be null or empty
    // title should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    // title should not be null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
