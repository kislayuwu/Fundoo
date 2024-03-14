package com.bridgelabz.fundoo.user.service;

import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.user.repository.UserRepository;
import com.bridgelabz.fundoo.user.model.User;
import com.bridgelabz.fundoo.utils.StatusHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Mono<com.bridgelabz.fundoo.response.Response> saveUser(User user) {
        return repository.save(user)
                .thenReturn(StatusHelper.statusInfo("User saved successfully", 200));
    }

    @Override
    public Mono<Response> deleteUserById(int id) {
        return repository.findById((int) id).flatMap(user -> repository.delete(user).then(Mono.just(user)))
                .thenReturn(StatusHelper.statusInfo("user successfully deleted", 200));
    }

    @Override
    public Flux<User> allUsers() {
        return repository.findAll();
    }

    @Override
    public Mono<User> showUserById(int id) {
        return repository.findById(id);
    }
}
