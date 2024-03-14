package com.bridgelabz.fundoo.label.service;

import com.bridgelabz.fundoo.label.model.Label;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILabelService {

   public Mono<Label> createLabel(Label label);
   public Flux<Label> getLabelsByUserId(Long userId);

}
