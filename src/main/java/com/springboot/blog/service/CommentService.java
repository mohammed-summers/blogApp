package com.springboot.blog.service;

import com.springboot.blog.dto.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
}
