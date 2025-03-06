package com.example.app1.requests;

import com.example.app1.entities.Post;
import lombok.Data;

@Data
public class CommentCreateRequest {
    Long id;
    Long userId;
    String text;
    Long postId;
}
