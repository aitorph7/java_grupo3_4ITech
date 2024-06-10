package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByVisibleTrue();

    List<Room> findAllByVisibleTrue();


}