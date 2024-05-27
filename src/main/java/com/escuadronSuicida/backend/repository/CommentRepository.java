package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByOrderByDateTimeDesc();

    List<Comment> findByKeynote_IdOrderByDateTimeDesc(Long keynoteId);


    @Transactional
    void deleteByKeynoteId(Long keynoteId);


}