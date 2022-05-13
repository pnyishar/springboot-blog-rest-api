package com.pantech.blog.respository;

import com.pantech.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Paul Nyishar
 * @Date 11/05/2022
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
