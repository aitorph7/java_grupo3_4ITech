package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {



}