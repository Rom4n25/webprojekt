package pl.romanek.webprojekt.crud.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pl.romanek.webprojekt.crud.domain.Person;

@Repository
public class InMemoryPersonRepository implements PersonRepository {

    private List<Person> personList = new ArrayList<>();

    @Override
    public Person getPersonById(String string) {

        Person person = null;
        for (Person personById : personList) {

            if (personById.getPersonId().equalsIgnoreCase(string)) {

                person = personById;
                break;
            }
        }
        return person;
    }

    @Override
    public Person getPersonByEmail(String string) {

        Person person = null;
        for (Person personByEmail : personList) {

            if (personByEmail.getEmail().equalsIgnoreCase(string)) {

                person = personByEmail;
                break;
            }
        }
        return person;
    }

    public InMemoryPersonRepository() {

        Person person1 = new Person("Mateusz", "Romanek", "romanek1802@gmail.com");
        personList.add(person1);

    }

    @Override
    public List<Person> getAllPerson() {

        return this.personList;

    }

    @Override
    public void deletePerson(Person person) {

        for (Person deletePerson : personList) {
            if (person.equals(deletePerson)) {

                personList.remove(deletePerson);
                break;
            }
        }
    }

    @Override
    public void addPerson(Person person) {

        personList.add(person);
    }

}
