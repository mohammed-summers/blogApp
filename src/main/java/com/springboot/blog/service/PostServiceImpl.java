package com.springboot.blog.service;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.entity.Post;
import com.springboot.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl {

    @Autowired
    private PostRepository postRepo;

    public PostDto createPost(PostDto postDto){
        Post post = postDtoToPost(postDto);
        Post newPost = postRepo.save(post);
        PostDto newPostDto = postToPostDto(newPost);
        return newPostDto;
    }



    private Post postDtoToPost(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getContent());
        post.setContent(postDto.getContent());
        return post;
    }

    private PostDto postToPostDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getContent());
        postDto.setContent(post.getContent());
        return postDto;
    }
}
