package com.dijkstress.redis.api;

import com.dijkstress.redis.domain.model.Users;
import com.dijkstress.redis.domain.port.UsersServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersServicePort usersServicePort;

    public  UsersController(UsersServicePort usersServicePort){
        this.usersServicePort=usersServicePort;
    }

    @PostMapping
    public Users createUser(@RequestBody Users user){
        return usersServicePort.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<Users> getUser(@PathVariable Long id){
        return usersServicePort.getUser(id);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return usersServicePort.getAllUsers();
    }
}
