package com.example.app1.repos;
import com.example.app1.entities.Comment;
import com.example.app1.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostId(Long postId);
    List<Comment> findByPostIdAndUserId(Long postId, Long userId);
}