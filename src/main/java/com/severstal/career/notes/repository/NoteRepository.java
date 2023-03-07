package com.severstal.career.notes.repository;

import com.severstal.career.notes.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    Note findById(long id);
}
