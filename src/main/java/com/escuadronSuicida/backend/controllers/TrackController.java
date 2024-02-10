package com.escuadronSuicida.backend.controllers;

import com.escuadronSuicida.backend.repository.TrackRepository;
import com.escuadronSuicida.backend.services.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TrackController {

    private TrackService trackService;

    private final TrackRepository trackRepository;

}
