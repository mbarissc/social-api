package com.example.app1.repos;
import com.example.app1.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long>{
    List<Like> findByUserId(Long userId);
    List<Like> findByPostId(Long postId);
    List<Like> findByPostIdAndUserId(Long postId, Long userId);

}
