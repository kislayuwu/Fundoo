package com.bridgelabz.fundoo.user.repository;

import com.bridgelabz.fundoo.user.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Integer> {

    Mono<Object> findByEmail(String email);
}
