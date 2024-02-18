package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    List<Address> findAddress();

    Address findByID(Long id);
}
