package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Track;

import java.util.List;

public interface TrackRepository {

    void saveAll(List<Track> tracks);
}
