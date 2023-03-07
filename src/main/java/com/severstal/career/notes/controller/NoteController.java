package com.severstal.career.notes.controller;

import com.severstal.career.notes.model.Note;
import com.severstal.career.notes.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping(path = "/")
    public String getNotes(Model model) {
        Iterable<Note> notes = this.noteService.findAll();
        model.addAttribute("notes", notes);
        return "notes";
    }
    @GetMapping(path = "/note-create")
    public String createNoteForm(Note note) {
        return "note-create";
    }

    @PostMapping(path = "/note-create")
    public String createNote(Note note) {
        this.noteService.saveNote(note);
        return "redirect:/";
    }

    @GetMapping(path = "/{id}")
    public Note getNote(@PathVariable long id) {
        return this.noteService.findById(id);
    }

    @GetMapping(path = "/note-delete/{id}")
    public String deleteNote(@PathVariable long id) {
        this.noteService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(path = "/note-update/{id}")
    public String updateNoteForm(@PathVariable long id, Model model) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "note-update";
    }

    @PostMapping(path = "/note-update")
    public String updateNote(Note note) {
        this.noteService.saveNote(note);
        return "redirect:/";
    }

}
