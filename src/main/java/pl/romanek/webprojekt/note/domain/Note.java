package pl.romanek.webprojekt.note.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Note {

    private String noteId;
    private Map<String, NoteItem> noteList;

    public Note() {

        Random generator = new Random();
        int rand = generator.nextInt(1000);
        int rand2 = generator.nextInt(10000);
        this.noteId = rand + rand2 + "";
        this.noteList = new HashMap<>();
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public Map<String, NoteItem> getNoteList() {
        return noteList;
    }

    public void setNoteList(Map<String, NoteItem> noteList) {
        this.noteList = noteList;
    }

    public void addNoteItem(NoteItem noteItem) {

        this.noteList.put(noteItem.getId(), noteItem);
    }

    public void deleteNote(String noteItemId) {

        this.noteList.remove(noteItemId);
    }

    public void updateNote(NoteItem noteItem) {

        this.noteList.put(noteItem.getId(), noteItem);
    }

}
