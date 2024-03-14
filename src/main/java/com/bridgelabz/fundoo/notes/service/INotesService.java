package com.bridgelabz.fundoo.notes.service;

import com.bridgelabz.fundoo.notes.model.Notes;
import com.bridgelabz.fundoo.response.Response;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface INotesService {
    public Mono<Response> saveNote(Notes note);

    public Mono<Response> deleteNote(int id);

    public Mono<Notes> showNotesById(int id);

    public Mono<Response> archiveNote(int id);

    public Mono<Response> pinNote(int id);

    public Mono<Response> trashNode(int id);

    public Mono<Response> unarchiveNote(int noteId);

    public Mono<Response> unpinNote(int noteId);

    public Mono<Response> restoreNoteFromTrash(int noteId);

    public Flux<Notes> showNotesByUserId(int userId);
}
