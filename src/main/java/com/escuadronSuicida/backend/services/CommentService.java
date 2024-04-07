package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {


    List<Comment> findCommentsOrderByDateTimeDesc();

    Comment findById(Long id);

    Comment createComment(Comment comment);

    Comment updateComment(Long id, Comment comment);

    boolean deleteComment(Long id);
}
