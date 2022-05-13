package com.pantech.blog.respository;

import com.pantech.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Paul Nyishar
 * @Date 09/05/2022
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
