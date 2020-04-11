package pl.romanek.webprojekt.crud.service;

import java.util.List;
import pl.romanek.webprojekt.crud.domain.Person;

public interface PersonService {

    void addPerson(Person person);

    void deletePerson(Person person);

    List<Person> getAllPerson();

    Person getPersonByEmail(String email);

    Person getPersonById(String id);
}
