package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Comment;
import com.escuadronSuicida.backend.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(Comment comment) {

        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()){
            commentOptional.get().setRating(comment.getRating());
            commentOptional.get().setUser(comment.getUser());
            commentOptional.get().setKeynote(comment.getKeynote());
            //esto es actualizar los atributos que se consideren necesarios
            return commentRepository.save(commentOptional.get());
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteComment(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()){
            commentRepository.deleteById(id);
            return true;
        } else { return false; }
    }
}
