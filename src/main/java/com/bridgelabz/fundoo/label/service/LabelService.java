package com.bridgelabz.fundoo.label.service;

import com.bridgelabz.fundoo.label.model.Label;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class LabelService implements ILabelService {
    @Override
    public Mono<Label> createLabel(Label label) {
        return null;
    }

    @Override
    public Flux<Label> getLabelsByUserId(Long userId) {
        return null;
    }
}
