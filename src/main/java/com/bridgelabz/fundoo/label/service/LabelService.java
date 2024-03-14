package com.bridgelabz.fundoo.label.service;

import com.bridgelabz.fundoo.label.model.Label;
import com.bridgelabz.fundoo.label.repository.LabelRepository;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.utils.StatusHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LabelService implements ILabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public Mono<Response> createLabel(Label label) {
        return Mono.just(labelRepository.save(label))
                .thenReturn(StatusHelper.statusInfo("Label created successfully", 200));
    }

    @Override
    public Flux<Label> getLabelsByNoteId(int noteId) {
        return labelRepository.findByNoteId(noteId);
    }

    }

