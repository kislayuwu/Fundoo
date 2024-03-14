package com.bridgelabz.fundoo.user.service;

import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.user.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

    public Flux<Object> saveUser(User user);

    public Mono<Response> deleteUserById(int id);

    public Flux<User> allUsers();

    public Mono<User> showUserById(int id);
}
