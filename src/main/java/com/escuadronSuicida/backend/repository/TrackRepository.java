package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {

}