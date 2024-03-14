package com.bridgelabz.fundoo.user.repository;

import com.bridgelabz.fundoo.user.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends R2dbcRepository<User, Integer> {

    Flux<Object> findByEmail(String email);
}
