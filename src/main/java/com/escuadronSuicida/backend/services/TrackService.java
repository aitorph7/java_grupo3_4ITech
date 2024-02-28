package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Track;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrackService {

    List<Track> findTracks();

    Track findById(Long id);

    Track createTrack(Track track);

    Track updateTrack(Long id, Track track);

    boolean deleteTrack(Long id);






}
