package pl.romanek.webprojekt.crud.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.romanek.webprojekt.crud.domain.Person;
import pl.romanek.webprojekt.crud.service.PersonService;

@Controller
@RequestMapping("/crud")
public class PersonController {

    @Autowired
    PersonService personService;

    @ModelAttribute("allPersons") //dzieki tej adnotacji nie musze pisac w innych metodach personService.getAllPerson();
    public List getAllPersons() { //zostaje dodana do modelu ogolnie

        return personService.getAllPerson();
    }

    @GetMapping
    public String mainPage() {
       
        return "crudView";
    }

    @GetMapping("/add")
    public String addGet(Model model, @ModelAttribute("newPerson") Person person) { //dodaję do modelu "newPerson"
                                                                                    //aby można było uzupełnić formularz
        model.addAttribute("flagAdd", true);
        model.addAttribute("buttonAddParam",true);
       

        return "crudView";
    }

    @PostMapping("/add")
    public String addPost(Model model, @Valid @ModelAttribute("newPerson") Person person, BindingResult result) { //dane przeslane z formularza są wiązane z tym Beanem Person
                                                            //jeszcze raz dodany do modelu "newPerson"
        if (result.hasErrors()) {                           //w przypadku gdy będzie błąd to formularz będzie go ponownie wymagał
            
            model.addAttribute("flagAdd",true);
           
            return "crudView";
        }

        personService.addPerson(person);

        return "redirect:/crud";
    }

    @GetMapping("/edit")
    public String editGet(Model model, @RequestParam("id") String id) {
       
        model.addAttribute("buttonAddParam",true);
        model.addAttribute("flagEdit", true);
        model.addAttribute("personById", personService.getPersonById(id));

        return "crudView";
    }

    @PostMapping("/edit")
    public String editPost(Model model, @Valid @ModelAttribute("personById") Person person, BindingResult result) {
        
        if(result.hasErrors()){
            
            model.addAttribute("flagEdit",true);
           
            return "crudView";
            
        }
        

        if (!person.getName().isEmpty()) {
            personService.getPersonById(person.getPersonId()).setName(person.getName());

        }

        if (!person.getSurname().isEmpty()) {

            personService.getPersonById(person.getPersonId()).setSurname(person.getSurname());

        }

        if (!person.getEmail().isEmpty()) {
            personService.getPersonById(person.getPersonId()).setEmail(person.getEmail());

        }

        return "redirect:/crud";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam("id") String id) {

        personService.deletePerson(personService.getPersonById(id));

        return "redirect:/crud";
    }

}
