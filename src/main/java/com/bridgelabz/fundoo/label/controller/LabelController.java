package com.bridgelabz.fundoo.label.controller;

import com.bridgelabz.fundoo.label.model.Label;
import com.bridgelabz.fundoo.label.service.LabelService;
import com.bridgelabz.fundoo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;

    @PostMapping("/saveLabel")
    public Mono<ResponseEntity<Response>> createLabel(@RequestBody Label label){
        return labelService.createLabel(label)
                .map(response -> ResponseEntity.ok().body(response));
    }
    @GetMapping("/userLabel/{noteId}")
    public Flux<Label> getLabelByUserId(@PathVariable int noteId){
        return labelService.getLabelsByNoteId(noteId);
    }
}
