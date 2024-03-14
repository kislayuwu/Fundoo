package com.bridgelabz.fundoo.label.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "label")
public class Label {

    @Id
    @Column("labelId")
    private Long labelId;

    @Column("noteId")
    private Long noteId;

    @Column("userId")
    private Long userId;

    @Column("title")
    private String title;

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Label{" +
                "labelId=" + labelId +
                ", noteId=" + noteId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                '}';
    }
}
