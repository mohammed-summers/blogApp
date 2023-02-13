package com.springboot.blog.service;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.payload.PostResponse;
import org.springframework.stereotype.Service;


@Service
public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long postId);
    PostDto updatePostById(PostDto postDto, Long postId);
    void deletePostById(long postId);



}
