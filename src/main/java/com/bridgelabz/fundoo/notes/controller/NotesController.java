package com.bridgelabz.fundoo.notes.controller;

import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.notes.model.Notes;
import com.bridgelabz.fundoo.notes.service.INotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
public class NotesController {

    @Autowired
    private INotesService notesService;

    @PostMapping("/saveNote")
    public Mono<ResponseEntity<Response>> saveNote(@RequestBody Notes note) {
        return notesService.saveNote(note)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @DeleteMapping("/deleteNote/{noteId}")
    public Mono<ResponseEntity<Response>> deleteNoteById(@PathVariable int noteId) {
        return notesService.deleteNote(noteId)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @GetMapping("/note/{noteId}")
    public Mono<Notes> showNoteById(@PathVariable int noteId) {
        return notesService.showNotesById(noteId);
    }

    @PostMapping("/archive/{noteId}")
    public Mono<ResponseEntity<Response>> archiveNote(@PathVariable int noteId) {
        return notesService.archiveNote(noteId)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @PostMapping("/pin/{noteId}")
    public Mono<ResponseEntity<Response>> pinNote(@PathVariable int noteId) {
        return notesService.pinNote(noteId)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @PostMapping("/trash/{noteId}")
    public Mono<ResponseEntity<Response>> trashNote(@PathVariable int noteId) {
        return notesService.trashNode(noteId)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @PostMapping("/unarchive/{noteId}")
    public Mono<ResponseEntity<Response>> unarchiveNote(@PathVariable int noteId) {
        return notesService.unarchiveNote(noteId)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @PostMapping("/unpin/{noteId}")
    public Mono<ResponseEntity<Response>> unpinNote(@PathVariable int noteId) {
        return notesService.unpinNote(noteId)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @PostMapping("restore/{noteId}")
    public Mono<ResponseEntity<Response>> restoreNoteFromTrash(@PathVariable int noteId) {
        return notesService.restoreNoteFromTrash(noteId)
                .map(response -> ResponseEntity.ok().body(response));
    }

    @GetMapping("/userNotes/{userId}")
    public Flux<Notes> showNotesByUserId(@PathVariable int userId) {
        return notesService.showNotesByUserId(userId);
    }
}
