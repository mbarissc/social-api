package com.example.app1.services;

import com.example.app1.entities.Like;
import com.example.app1.entities.Post;
import com.example.app1.entities.User;
import com.example.app1.repos.LikeRepository;
import com.example.app1.requests.LikeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {


    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()) {
            return likeRepository.findByPostIdAndUserId(postId.get(), userId.get());
        }
        else if(userId.isPresent()) {
            return likeRepository.findByUserId(userId.get());

        }
        else if(postId.isPresent()) {
            return likeRepository.findByPostId(postId.get());

        }
        else{
            return likeRepository.findAll();
        }

    }

    public Like getOneLike(Long id) {
        return likeRepository.findById(id).get();
    }

    public void deleteOneLike(Long id) {
        likeRepository.deleteById(id);
    }

    public Like CreateOneLike(LikeCreateRequest newLikeRequest){
        User user = userService.getOneUser(newLikeRequest.getUserId());
        Post post = postService.getOnePostById(newLikeRequest.getPostId());

        if(user==null || post==null) {
            return null;
        }

        Like toSave = new Like();
        toSave.setUser(user);
        toSave.setPost(post);
        toSave.setId(newLikeRequest.getId());
        return likeRepository.save(toSave);
    }

}
