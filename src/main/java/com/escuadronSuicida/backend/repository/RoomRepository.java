package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}