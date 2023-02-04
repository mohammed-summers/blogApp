package com.springboot.blog.controller;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.entity.Post;
import com.springboot.blog.service.PostService;
import com.springboot.blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto newPostDto = postService.createPost(postDto);
        return new ResponseEntity<>(newPostDto, HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> allPosts = postService.getAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long postId){
        PostDto postById = postService.getPostById(postId);
        return new ResponseEntity<>(postById, HttpStatus.OK);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable("id") Long postId){
        PostDto updatedPostDto = postService.updatePostById(postDto, postId);
        return new ResponseEntity<>(updatedPostDto, HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable("id") long postId){
        postService.deletePostById(postId);
        return new ResponseEntity<>("Post Entity was deleted", HttpStatus.OK);
    }

}
