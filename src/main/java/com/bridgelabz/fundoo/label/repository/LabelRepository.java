package com.bridgelabz.fundoo.label.repository;

import com.bridgelabz.fundoo.label.model.Label;
import com.bridgelabz.fundoo.notes.model.Notes;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface LabelRepository extends R2dbcRepository<Label, Integer> {
    public Flux<Label> findByNoteId(int noteId);

}
