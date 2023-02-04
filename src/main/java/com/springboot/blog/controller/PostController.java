package com.springboot.blog.controller;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.entity.Post;
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
    private PostServiceImpl postServiceImpl;


    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto newPostDto = postServiceImpl.createPost(postDto);
        return new ResponseEntity<>(newPostDto, HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> allPosts = postServiceImpl.getAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Long postId){
        PostDto postById = postServiceImpl.getPostById(postId);
        return new ResponseEntity<>(postById, HttpStatus.OK);
    }

//    @GetMapping("/student/{id}")
//    public Student studentPathVariable(@PathVariable("id") int studentId){
//        Student student = new Student(studentId, "selma", "summers");
//        return student;
//    }

    @GetMapping("/h")
    public String hello(){
        return  "hello";
    }
}
