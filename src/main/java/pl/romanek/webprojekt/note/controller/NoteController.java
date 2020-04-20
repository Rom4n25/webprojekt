package pl.romanek.webprojekt.note.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.romanek.webprojekt.note.service.NoteService;

@Controller
public class NoteController {
    
    NoteService noteService;

    @RequestMapping("/note")
    public String createNote(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
   
        
        model.addAttribute("note", currentPrincipalName);

        return "noteView";

    }

}
