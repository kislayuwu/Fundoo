package com.bridgelabz.fundoo.notes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.annotation.processing.Generated;

@Table("notes")
public class Notes {

    @Id
    @Column("noteId")
    private int noteId;
    @Column("note")
    private String note;
    @Column("userId")
    private int userId;
    @Column("trash")
    private boolean trash;
    @Column("archive")
    private boolean archive;
    @Column("pinned")
    private boolean pinned;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isTrash() {
        return trash;
    }

    public void setTrash(boolean trash) {
        this.trash = trash;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                ", userId=" + userId +
                ", trash=" + trash +
                ", archive=" + archive +
                ", pinned=" + pinned +
                '}';
    }
}
