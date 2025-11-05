package com.dijkstress.redis.infrastructure.repository;

import com.dijkstress.redis.domain.model.Users;
import com.dijkstress.redis.domain.port.UsersRepositoryPort;
import com.dijkstress.redis.infrastructure.entity.UsersEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsersRepositoryAdapter implements UsersRepositoryPort {

    private final JpaUsersRepository jpaUsersRepository;

    public UsersRepositoryAdapter(JpaUsersRepository jpaUsersRepository){
        this.jpaUsersRepository=jpaUsersRepository;
    }

    @Override
    public Users save(Users user) {
        UsersEntity entity = new UsersEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UsersEntity saved = jpaUsersRepository.save(entity);
        return new Users(saved.getId(),saved.getName(), saved.getEmail());
    }

    @Override
    public Optional<Users> findById(Long id) {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        return jpaUsersRepository.findById(id)
                .map(e -> new Users(e.getId(), e.getName(), e.getEmail()));
    }

    @Override
    public List<Users> findAll() {
        return jpaUsersRepository.findAll()
                .stream()
                .map(e -> new Users(e.getId(), e.getName(), e.getEmail()))
                .collect(Collectors.toList());
    }
}
