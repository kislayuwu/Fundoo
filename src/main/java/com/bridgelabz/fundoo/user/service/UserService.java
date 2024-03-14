package com.bridgelabz.fundoo.user.service;

import com.bridgelabz.fundoo.exception.ResourceAlreadyExistsException;
import com.bridgelabz.fundoo.exception.ResourceNotFoundException;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.user.model.User;
import com.bridgelabz.fundoo.user.repository.UserRepository;
import com.bridgelabz.fundoo.utils.StatusHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Flux<Object> saveUser(User user) {
        return repository.findByEmail(user.getEmail())
                .flatMap(existingUser -> Mono.error(new ResourceAlreadyExistsException("User with email " + user.getEmail() + " already exists")))
                .switchIfEmpty(repository.save(user)
                        .thenReturn(StatusHelper.statusInfo("User saved successfully", 200)))
                .onErrorResume(DataIntegrityViolationException.class,
                        ex -> Mono.error(new ResourceAlreadyExistsException("User with email " + user.getEmail() + " already exists")));
    }

    @Override
    public Mono<Response> deleteUserById(int id) {
        return repository.findById((int) id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("User not found with id " + id)))
                .flatMap(user -> repository.delete(user).then(Mono.just(user)))
                .thenReturn(StatusHelper.statusInfo("User successfully deleted", 200));
    }

    @Override
    public Flux<User> allUsers() {
        return repository.findAll();
    }

    @Override
    public Mono<User> showUserById(int id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("User not found with id " + id)));
    }
}
