package com.springboot.blog.service;

import com.springboot.blog.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getAllCommentsByPostId(Long postId);
    CommentDto getCommentById(Long postId, Long commentId);
}
