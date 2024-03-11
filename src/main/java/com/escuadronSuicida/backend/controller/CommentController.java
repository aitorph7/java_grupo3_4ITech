package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.Comment;
import com.escuadronSuicida.backend.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("comments")
    public ResponseEntity <List<Comment>> findAll() {

        List<Comment> comments = commentService.findComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("comments/{id}")
    public ResponseEntity <Comment> findById(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        if (comment!=null) {
            return ResponseEntity.ok(comment);
            } else {
                return ResponseEntity.notFound().build();

        }
    }
    @PostMapping("comments")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(comment);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
        // return ResponseEntity.ok(commentRepository.save(comment); seria lo mismo pero sin llamar a CommentService

    }
    @PutMapping("comments/{id}")
    public ResponseEntity<Comment> updateTrack(@PathVariable Long id, @RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(id,comment);
        if (updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        boolean deleted = commentService.deleteComment(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }


    }

}
