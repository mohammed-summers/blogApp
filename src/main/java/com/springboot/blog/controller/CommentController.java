package com.springboot.blog.controller;

import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") Long postId, @Valid @RequestBody CommentDto commentDto){
        CommentDto comment = commentService.createComment(postId, commentDto);
        return new ResponseEntity(comment, HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getAllCommentsByPostId(@PathVariable (value = "postId") Long postId){
        List<CommentDto> allCommentsByPostId = commentService.getAllCommentsByPostId(postId);
        return new ResponseEntity<>(allCommentsByPostId, HttpStatus.OK);
    }
    
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable (value = "postId") Long postId, 
                                                     @PathVariable (value = "commentId") Long commentId){
        CommentDto commentById = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentById, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable (value = "postId") Long postId,
                                                        @PathVariable (value = "commentId") Long commentId,
                                                        @Valid @RequestBody CommentDto commentDto){
        CommentDto updatedCommentDto = commentService.updateCommentById(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedCommentDto, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteCommentById(@PathVariable (value = "postId") Long postId,
                                                    @PathVariable (value = "commentId") Long commentId){
        commentService.deleteCommentById(postId, commentId);
        return new ResponseEntity<>("comment deleted", HttpStatus.OK);
    }
}
