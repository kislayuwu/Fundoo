package com.bridgelabz.fundoo.label.service;

import com.bridgelabz.fundoo.label.model.Label;
import com.bridgelabz.fundoo.response.Response;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILabelService {

   public Mono<Response> createLabel(Label label);
   public Flux<Label> getLabelsByNoteId(int noteId);

}
