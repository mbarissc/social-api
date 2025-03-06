package com.example.app1.controllers;

import com.example.app1.entities.Like;
import com.example.app1.requests.LikeCreateRequest;
import com.example.app1.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId) {
       return likeService.getAllLikes(userId, postId);
    }

    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId) {
        return likeService.getOneLike(likeId);
    }

    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest newLikeRequest) {
        return likeService.CreateOneLike(newLikeRequest);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        likeService.deleteOneLike(likeId);
    }




}
