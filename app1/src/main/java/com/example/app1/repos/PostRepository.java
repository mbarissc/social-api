package com.example.app1.repos;
import com.example.app1.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByUserId(Long userId);

}