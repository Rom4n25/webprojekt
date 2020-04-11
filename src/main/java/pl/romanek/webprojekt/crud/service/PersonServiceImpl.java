package pl.romanek.webprojekt.crud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.romanek.webprojekt.crud.domain.Person;
import pl.romanek.webprojekt.crud.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person getPersonById(String string) {

        return personRepository.getPersonById(string);
    }

    @Override
    public Person getPersonByEmail(String string) {

        return personRepository.getPersonByEmail(string);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.getAllPerson();
    }

    @Override
    public void addPerson(Person person) {

        personRepository.addPerson(person);

    }

    @Override
    public void deletePerson(Person person) {
        personRepository.deletePerson(person);
    }

}
