package com.dijkstress.redis.domain.port;

import com.dijkstress.redis.domain.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersServicePort {
    Users createUser(Users user);
    Optional<Users> getUser(Long id);
    List<Users> getAllUsers();
}
