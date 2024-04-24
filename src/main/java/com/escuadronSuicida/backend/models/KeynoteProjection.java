package com.escuadronSuicida.backend.models;

public record KeynoteProjection(
        Long id,
        String title,
        String summary,
        String description,
        String photoUrl,
        Room room,
        Long maxNumPersons,
        DifficultyLevel difficultyLevel,
        Integer durationInMin,
        User speaker,
        Track track

        ) {
}
