package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAllByUserRole(UserRole userRole);

    boolean existsByEmail(String email);
}