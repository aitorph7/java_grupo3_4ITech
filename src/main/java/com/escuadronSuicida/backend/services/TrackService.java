package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Track;

import java.util.List;

public interface TrackService {


    List<Track> findTracks();

    Track findById(Long id);

    Track createTrack(Track track);

    Track updateTrack(Long id, Track track);

    boolean deleteTrack(Long id);

    List<Track> findTrackVisibleTrue();
}
