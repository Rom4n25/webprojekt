package pl.romanek.webprojekt.note.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pl.romanek.webprojekt.note.domain.Note;
import pl.romanek.webprojekt.note.domain.NoteItem;

@Repository
public class InMemoryNoteRepository implements NoteRepository {

    private Map<String, Note> listOfNotes;

    public InMemoryNoteRepository(Map<String, Note> listOfNotes) {
        this.listOfNotes = new HashMap<>();

        Note myNote = new Note();
        myNote.setNoteId("admin"); //przyjalem sobie ze idNote to bedzie nazwa uzytkownika bo ona i tak jest unikalna
        this.listOfNotes.put(myNote.getNoteId(), myNote);

    }

    @Override
    public Note create(Note note) {

        listOfNotes.put(note.getNoteId(), note);

        return listOfNotes.get(note.getNoteId());
    }

    @Override
    public Note read(String noteId) {

        return listOfNotes.get(noteId);
    }

    @Override
    public void update(String noteId, Note note) {

        listOfNotes.put(noteId, note);
    }

    @Override
    public void delete(String noteId) {
        
        listOfNotes.remove(noteId);
    }

    @Override
    public NoteItem getNoteItem(String noteId, String noteItemId) {

        return listOfNotes.get(noteId).getNoteList().get(noteItemId);

    }

}
