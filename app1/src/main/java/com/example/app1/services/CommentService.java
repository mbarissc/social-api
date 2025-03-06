package com.example.app1.services;

import com.example.app1.entities.Comment;
import com.example.app1.entities.Post;
import com.example.app1.entities.User;
import com.example.app1.repos.CommentRepository;
import com.example.app1.requests.CommentCreateRequest;
import com.example.app1.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;


    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllComments(Optional<Long> postId, Optional<Long> userId) {
        if(postId.isPresent() && userId.isPresent()) {
            return commentRepository.findByPostIdAndUserId(postId.get(), userId.get());
        }
        else if(userId.isPresent())
            return commentRepository.findByUserId(userId.get());
        else if(postId.isPresent())
            return commentRepository.findByPostId(postId.get());
        else return commentRepository.findAll();
    }

    public Comment getOneComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void deleteOneComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Comment createOneComment(CommentCreateRequest newCommentRequest) {
        User user = userService.getOneUser(newCommentRequest.getUserId());
        Post post = postService.getOnePostById(newCommentRequest.getPostId());
        if(user==null || post==null)
            return null;
        Comment toSave = new Comment();
        toSave.setId(newCommentRequest.getId());
        toSave.setText(newCommentRequest.getText());
        toSave.setUser(user);
        toSave.setPost(post);
        return commentRepository.save(toSave);
    }

    public Comment updateCommentById(Long id, CommentUpdateRequest newCommentRequest) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            Comment toUpdate = comment.get();
            toUpdate.setText(newCommentRequest.getText());
            commentRepository.save(toUpdate);
            return toUpdate;

        }
        return null;
    }


}
