package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Track;
import com.escuadronSuicida.backend.repository.TrackRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public List<Track> findTracks() {
        return trackRepository.findAll();

    }

    @Override
    public Track findById(Long id) {
        return trackRepository.findById(id).orElse(null);

    }

    @Override
    public Track createTrack(Track track) {
        Logger logger = LoggerFactory.getLogger(Track.class);
        try {
            return trackRepository.save(track);
        } catch (Exception e) {
            // Registrar el error
            logger.error("Hubo un error al crear el track", e);

            // Lanzar una nueva excepción
            throw new RuntimeException("Hubo un error al crear el track: " + e.getMessage(), e);
        }
    }


    @Override
    public boolean updateTrack(Long id, Track track) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isPresent()) {
            Track trackFromDatabase = trackOptional.get();
            trackFromDatabase.setName(track.getName());
            trackFromDatabase.setStartDate(track.getStartDate());
            trackFromDatabase.setEndDate(track.getEndDate());
            trackRepository.save(trackFromDatabase);

            return true;
            // esto es actualizar solo esos atributos como sea necesario, aunque en este caso son todos.
        } else {
            return false;
        }
    }


    @Override
    public boolean deleteTrack(Long id) {

        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isPresent()) {
            trackRepository.deleteById(id);
            return true;
        } else {
            return false;
        }


    }
}