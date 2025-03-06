package com.example.app1.services;

import com.example.app1.entities.Post;
import com.example.app1.entities.User;
import com.example.app1.repos.PostRepository;
import com.example.app1.requests.PostCreateRequest;
import com.example.app1.requests.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId){
       if(userId.isPresent())
            return postRepository.findByUserId(userId.get());
       return postRepository.findAll();
    }

    public Post getOnePostById(Long id){
        return postRepository.findById(id).orElse(null);

    }

    public Post createOnePost(PostCreateRequest newPostRequest){
        User user =userService.getOneUser(newPostRequest.getUserId());
        if(user==null)
            return null;
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setText(newPostRequest.getText());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setTitle(updatePost.getTitle());
            toUpdate.setText(updatePost.getText());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }
}
