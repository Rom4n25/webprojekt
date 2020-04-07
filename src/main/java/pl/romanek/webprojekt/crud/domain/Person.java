
package pl.romanek.webprojekt.crud.domain;

import java.util.Random;

public class Person {
    
    Random generator = new Random();
    
    private String personId;
    private String name;
    private String surname;
    private String email;

   
    
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        int rand = generator.nextInt(1000);
        this.personId = "P"+rand;
    }

        public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
