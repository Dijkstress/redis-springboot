package com.dijkstress.redis.application.service;

import com.dijkstress.redis.domain.model.Users;
import com.dijkstress.redis.domain.port.UsersRepositoryPort;
import com.dijkstress.redis.domain.port.UsersServicePort;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersServicePort {

   private final UsersRepositoryPort usersRepositoryPort;

   public UsersServiceImpl(UsersRepositoryPort usersRepositoryPort){
       this.usersRepositoryPort=usersRepositoryPort;
   }

    @Override
    public Users createUser(Users user) {
        return usersRepositoryPort.save(user);
    }

    @Override
    @Cacheable(value="users",key="#id")
    public Optional<Users> getUser(Long id) {
        return usersRepositoryPort.findById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepositoryPort.findAll();
    }
}
