package pl.romanek.webprojekt.note.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.romanek.webprojekt.note.domain.Note;
import pl.romanek.webprojekt.note.domain.NoteItem;
import pl.romanek.webprojekt.note.service.NoteService;

@RestController
@RequestMapping("/rest/crud")
public class NoteRestController {

    @Autowired
    NoteService noteService;

    @PostMapping()
    public Note create(@RequestBody Note note) {

        return noteService.create(note);

    }

    @GetMapping("/{noteId}")
    public Note read(@PathVariable("noteId") String noteId) {

        return noteService.read(noteId);
    }

    @DeleteMapping("/{noteId}")
    
    public void delete(@PathVariable("noteId") String noteId) {

        noteService.delete(noteId);
    }
    @PutMapping("/{noteId")
    
    public void update(@PathVariable("noteId") String noteId, @RequestBody Note note) {

        noteService.update(noteId, note);
    }
   
    @PutMapping("/add/{noteId}")
    public String addBlankNoteItem(@PathVariable("noteId") String noteId) {

        Note note = noteService.read(noteId);
        NoteItem noteItem = new NoteItem();
        note.addNoteItem(noteItem);
        noteService.update(note.getNoteId(), note);

        return noteItem.getId();
    }

    @PutMapping("/set/{noteId}/{noteItemId}/{title}/{dsc}")
    public void setNoteItemTitleAndDescription(@PathVariable("noteId") String noteId, @PathVariable("noteItemId") String noteItemId, @PathVariable("title") String title, @PathVariable("dsc") String dsc) {
  
        Note note = noteService.read(noteId);
        NoteItem noteItem = noteService.getNoteItem(noteId, noteItemId);
        noteItem.setTitle(title);
        noteItem.setDescription(dsc);

        noteService.update(noteId, note);

    }

    @PutMapping("/delete/{noteId}/{noteItemId}")
    public void deleteNoteItem(@PathVariable("noteId") String noteId, @PathVariable("noteItemId") String noteItemId) {

        noteService.read(noteId).deleteNote(noteItemId);

    }
}
