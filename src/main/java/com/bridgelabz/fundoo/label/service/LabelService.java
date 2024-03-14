package com.bridgelabz.fundoo.label.service;

import com.bridgelabz.fundoo.exception.ResourceAlreadyExistsException;
import com.bridgelabz.fundoo.label.model.Label;
import com.bridgelabz.fundoo.label.repository.LabelRepository;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.utils.StatusHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LabelService implements ILabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public Mono<Response> createLabel(Label label) {
        // Check if a label with the same title already exists
        return labelRepository.findByTitle(label.getTitle())
                .flatMap(existingLabel -> Mono.error(new ResourceAlreadyExistsException("Label with title " + label.getTitle() + " already exists")))
                .switchIfEmpty(Mono.defer(() -> Mono.just(labelRepository.save(label))))
                .thenReturn(StatusHelper.statusInfo("Label created successfully", 200))
                .onErrorResume(DataIntegrityViolationException.class,
                        ex -> Mono.error(new ResourceAlreadyExistsException("Label with title " + label.getTitle() + " already exists")));
    }

    @Override
    public Flux<Label> getLabelsByNoteId(int noteId) {
        // Retrieve labels by note ID
        return labelRepository.findByNoteId(noteId);
    }
}

