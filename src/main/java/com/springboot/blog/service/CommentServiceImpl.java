package com.springboot.blog.service;

import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private PostRepository postRepo;

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = convertToEntity(commentDto);

        //find post by id
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        comment.setPost(post);

        //save comment to DB
        Comment newComment = commentRepo.save(comment);
        return convertToDto(newComment);
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepo.findByPostId(postId);
        List<CommentDto> commentDtos = comments.stream().map(comment -> convertToDto(comment)).collect(Collectors.toList());
        return commentDtos;
    }


    private Comment convertToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }

    private CommentDto convertToDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }
}
