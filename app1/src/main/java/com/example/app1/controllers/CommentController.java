package com.example.app1.controllers;

import com.example.app1.entities.Comment;
import com.example.app1.requests.CommentCreateRequest;
import com.example.app1.requests.CommentUpdateRequest;
import com.example.app1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId) {
        return commentService.getAllComments(postId, userId);
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId) {
        return commentService.getOneComment(commentId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteOneComment(commentId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest newComment) {
        return commentService.createOneComment(newComment);
    }
    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updateComment) {
        return commentService.updateCommentById(commentId, updateComment);
    }

}
