package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.exception.UnauthorizedException;
import com.escuadronSuicida.backend.models.Comment;
import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import com.escuadronSuicida.backend.repository.CommentRepository;
import com.escuadronSuicida.backend.security.SecurityUtils;
import com.escuadronSuicida.backend.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class CommentController {
    private final CommentService commentService;
    private CommentRepository commentRepository;

    public CommentController(CommentService commentService, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    @GetMapping("comments")
    public ResponseEntity<List<Comment>> findAllByOrderByDateTimeDesc() {

        List<Comment> comments = commentService.findCommentsOrderByDateTimeDesc();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("comments/filter-by-keynote/{id}")
    public List<Comment> findAllByKeynoteId(@PathVariable Long id) {
        return commentService.findByKeynote_Id(id);
    }

    @GetMapping("comments/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        if (comment != null) {
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping("comments")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        SecurityUtils.getCurrentUser().ifPresent(user -> comment.setUser(user));
        Comment createdComment = commentService.createComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
        // return ResponseEntity.ok(commentRepository.save(comment); seria lo mismo pero sin llamar a CommentService

    }

    @PutMapping("comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(id, comment);
        if (updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @DeleteMapping("comments/{id}")
//    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
//        boolean deleted = commentService.deleteComment(id);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }

    @DeleteMapping("comments/{id}")
    public void deleteById(@PathVariable Long id) {

        Comment comment = this.commentRepository.findById(id).orElseThrow();
        User user = SecurityUtils.getCurrentUser().orElseThrow();

        if (user.getUserRole().equals(UserRole.ADMIN) ||
                (comment.getUser() != null && comment.getUser().getId().equals(user.getId()))
        )
            this.commentRepository.deleteById(id);
        else
            throw new UnauthorizedException("No puede borrar el comentario");
    }
}



