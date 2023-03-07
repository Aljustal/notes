package com.severstal.career.notes.service;

import com.severstal.career.notes.model.Note;
import com.severstal.career.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }
    public void saveNote(Note note) {
        noteRepository.save(note);
    }
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
