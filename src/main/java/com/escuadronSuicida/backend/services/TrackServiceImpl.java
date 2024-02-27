package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Track;
import com.escuadronSuicida.backend.repository.TrackRepository;

import java.util.List;

public class TrackServiceImpl implements TrackService{

private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    @Override
    public List<Track> findAll() {
        return null;
    }
    @Override
    public Track findById(Long id) {
        return null;
    }




}
