package com.springboot.blog.service;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.payload.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize);
    PostDto getPostById(long postId);
    PostDto updatePostById(PostDto postDto, Long postId);
    void deletePostById(long postId);



}
