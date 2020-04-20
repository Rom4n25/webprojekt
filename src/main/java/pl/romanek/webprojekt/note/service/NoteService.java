
package pl.romanek.webprojekt.note.service;

import pl.romanek.webprojekt.note.domain.Note;
import pl.romanek.webprojekt.note.domain.NoteItem;

public interface NoteService {
    
   Note create(Note note);
   Note read (String noteId);
   void update (String noteId, Note note);
   void delete (String noteId);
    
   NoteItem getNoteItem(String noteId, String noteItemId);
}
