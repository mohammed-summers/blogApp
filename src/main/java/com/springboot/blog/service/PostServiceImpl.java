package com.springboot.blog.service;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Override
    public PostDto createPost(PostDto postDto){
        Post post = postDtoToPost(postDto);
        Post newPost = postRepo.save(post);
        PostDto newPostDto = postToPostDto(newPost);
        return newPostDto;
    }

    @Override
    public List<PostDto> getAllPosts(){
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> allPost = postRepo.findAll();
        for (Post post:allPost){
            PostDto postDto = new PostDto();
            postDtos.add(postToPostDto(post));
        }
        return postDtos;
    };

    @Override
    public PostDto getPostById(long postId){
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return postToPostDto(post);
    };

    @Override
    public PostDto updatePostById(PostDto postDto, Long postId){
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepo.save(post);
        return postToPostDto(updatedPost);
    }

    @Override
    public void deletePostById(long postId){
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        postRepo.delete(post);
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
