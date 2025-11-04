package com.dijkstress.redis.infrastructure.repository;

import com.dijkstress.redis.infrastructure.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsersRepository extends JpaRepository<UsersEntity,Long> {
}
