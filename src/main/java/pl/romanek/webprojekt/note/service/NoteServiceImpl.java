package pl.romanek.webprojekt.note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.romanek.webprojekt.note.domain.Note;
import pl.romanek.webprojekt.note.domain.NoteItem;
import pl.romanek.webprojekt.note.repository.NoteRepository;


@Service
public class NoteServiceImpl implements NoteService{


    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note create(Note note) {
        return noteRepository.create(note);
    }

    @Override
    public Note read(String noteId) {
       return noteRepository.read(noteId);
    }

    @Override
    public void update(String noteId, Note note) {
        noteRepository.update(noteId, note);
    }

    @Override
    public void delete(String noteId) {
        noteRepository.delete(noteId);
    }
    
    
    @Override
    public NoteItem getNoteItem(String noteId, String noteItemId) {
        return noteRepository.getNoteItem(noteId, noteItemId);
    }
    
    
}
