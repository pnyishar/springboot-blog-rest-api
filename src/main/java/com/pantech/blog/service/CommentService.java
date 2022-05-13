package com.pantech.blog.service;

import com.pantech.blog.dto.CommentDto;

import java.util.List;

/**
 * @author Paul Nyishar
 * @Date 11/05/2022
 */
public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest);

    void deleteComment(Long postId, Long commentId);
}
