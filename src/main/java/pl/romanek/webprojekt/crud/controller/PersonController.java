package pl.romanek.webprojekt.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping
    public String mainPage(Model model) {

        model.addAttribute("person", personService.getAllPerson());

        return "crudMain";
    }

    @PostMapping("/add")
    public String add1(@ModelAttribute("person") Person person) {

        personService.addPerson(person);

        return "redirect:/crud";
    }

    @GetMapping("/add")
    public String add2(Model model) {

        model.addAttribute("person", personService.getAllPerson());

        return "crudAdd";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") String id) {

        personService.deletePerson(personService.getPersonById(id));

        return "redirect:/crud";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") String id) {

        model.addAttribute("person", personService.getPersonById(id));

        return "crudEdit";
    }

    @PostMapping("/edit")
    public String edit2(@ModelAttribute("person") Person person) {

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

}
