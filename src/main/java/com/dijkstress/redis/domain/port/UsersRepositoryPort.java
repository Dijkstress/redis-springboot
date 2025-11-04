package com.dijkstress.redis.domain.port;

import com.dijkstress.redis.domain.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepositoryPort {

    Users save(Users user);
    Optional<Users> findById(Long id);
    List<Users> findAll();
}
