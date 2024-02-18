package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}