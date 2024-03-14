package com.bridgelabz.fundoo.notes.service;

import com.bridgelabz.fundoo.notes.model.Notes;
import com.bridgelabz.fundoo.notes.repository.NotesRepository;
import com.bridgelabz.fundoo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.fundoo.utils.StatusHelper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NotesService implements INotesService {

    @Autowired
    private NotesRepository repository;

    @Override
    public Mono<Response> saveNote(Notes note) {
        return repository.save(note)
                .thenReturn(StatusHelper.statusInfo("Note saved successfully", 200));
    }

    @Override
    public Mono<Response> deleteNote(int id) {
        return repository.findById(id)
                .flatMap(note -> repository.delete(note).then(Mono.just(note)))
                .thenReturn(StatusHelper.statusInfo("Note deleted successfully", 200));
    }

    @Override
    public Mono<Notes> showNotesById(int id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Response> archiveNote(int id) {
        return repository.findById(id)
                .flatMap(note -> {
                    note.setArchive(true);
                    return repository.save(note);
                })
                .thenReturn(StatusHelper.statusInfo("Note archived successfully", 200));
    }

    @Override
    public Mono<Response> pinNote(int id) {
        return repository.findById(id)
                .flatMap(note -> {
                    note.setPinned(true);
                    return repository.save(note);
                })
                .thenReturn(StatusHelper.statusInfo("Note pinned successfully", 200));
    }

    @Override
    public Mono<Response> trashNode(int id) {
        return repository.findById(id)
                .flatMap(note -> {
                    note.setTrash(true);
                    return repository.save(note);
                })
                .thenReturn(StatusHelper.statusInfo("Note moved to trash successfully", 200));
    }

    @Override
    public Mono<Response> unarchiveNote(int noteId) {
        return repository.findById(noteId)
                .flatMap(note -> {
                    note.setArchive(false);
                    return repository.save(note);
                })
                .thenReturn(StatusHelper.statusInfo("Note unarchived successfully", 200));
    }

    @Override
    public Mono<Response> unpinNote(int noteId) {
        return repository.findById(noteId)
                .flatMap(note -> {
                    note.setPinned(false);
                    return repository.save(note);
                })
                .thenReturn(StatusHelper.statusInfo("Note unpinned successfully", 200));
    }

    @Override
    public Mono<Response> restoreNoteFromTrash(int noteId) {
        return repository.findById(noteId)
                .flatMap(note -> {
                    note.setTrash(false);
                    return repository.save(note);
                })
                .thenReturn(StatusHelper.statusInfo("Note restored from trash successfully", 200));
    }

    @Override
    public Flux<Notes> showNotesByUserId(int userId) {
        return repository.findByUserId(userId);
    }
}
