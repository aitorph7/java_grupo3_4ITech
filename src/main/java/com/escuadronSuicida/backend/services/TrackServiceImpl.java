package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Track;
import com.escuadronSuicida.backend.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

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
        return trackRepository.save(track);

    }

    @Override
    public Track updateTrack(Long id, Track track) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isPresent()) {
            trackOptional.get().setName(track.getName());
            trackOptional.get().setStartDate(track.getStartDate());
            trackOptional.get().setEndDate(track.getEndDate());
            // esto es actualizar solo esos atributos como sea neceario, aunque en este caso son todos.
            return trackRepository.save(trackOptional.get());
        } else {
        return null;
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
