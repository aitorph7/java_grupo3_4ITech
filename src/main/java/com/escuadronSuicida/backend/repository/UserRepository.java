package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAllByUserRole(UserRole userRole);

    boolean existsByEmail(String email);
}