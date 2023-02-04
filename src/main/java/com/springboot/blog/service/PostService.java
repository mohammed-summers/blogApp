package com.springboot.blog.service;

import com.springboot.blog.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long postId);
    PostDto updatePostById(PostDto postDto, Long postId);
    void deletePostById(long postId);



}
