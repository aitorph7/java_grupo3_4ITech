package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}