package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

}