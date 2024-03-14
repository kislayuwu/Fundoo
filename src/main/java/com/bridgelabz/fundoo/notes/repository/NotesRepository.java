package com.bridgelabz.fundoo.notes.repository;

import com.bridgelabz.fundoo.notes.model.Notes;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface NotesRepository extends R2dbcRepository<Notes, Integer> {
    public Flux<Notes> findByUserId(int userId);

}
