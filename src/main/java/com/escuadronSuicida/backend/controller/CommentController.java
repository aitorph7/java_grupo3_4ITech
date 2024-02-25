package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.Comment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class CommentController {
    List<Comment> comments;

}
