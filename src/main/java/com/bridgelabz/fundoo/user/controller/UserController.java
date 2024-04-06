package com.bridgelabz.fundoo.user.controller;

import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.user.model.User;
import com.bridgelabz.fundoo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/saveUser")
    public Mono<ResponseEntity<Object>> registerUser(@RequestBody User user) {
        return service.saveUser(user)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @GetMapping("/AllUsers")
    public Flux<User> allUsers(){
        return service.allUsers();
    }

    @GetMapping("/user/{userId}")
    public Mono<User> showUserById(@PathVariable String userId){
        return service.showUserById(Integer.parseInt(userId));
    }

    @DeleteMapping("/user/{userId}")
    public Mono<ResponseEntity<Response>> deleteUserById(@PathVariable String userId){
        return service.deleteUserById(Integer.parseInt(userId))
                .map(response -> ResponseEntity.ok().body(response));
    }
}


