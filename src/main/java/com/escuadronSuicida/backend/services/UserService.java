package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    List<User> findUser();

    User findById(Long id);


}
