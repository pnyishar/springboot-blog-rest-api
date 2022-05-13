package com.pantech.blog.service;

import com.pantech.blog.dto.PostDto;
import com.pantech.blog.dto.PostResponse;
import com.pantech.blog.entity.Post;

import java.util.List;

/**
 * @author Paul Nyishar
 * @Date 09/05/2022
 */
public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(Long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);
}
