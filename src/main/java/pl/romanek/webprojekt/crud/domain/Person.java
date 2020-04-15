
package pl.romanek.webprojekt.crud.domain;

import java.util.Random;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
public class Person {
    
    Random generator = new Random();
    
    private String personId;
    @NotBlank(message="{Pattern.Person.notBlank.validation}")
    @Pattern(regexp="^[a-zA-Z]+$", message="{Pattern.Person.name.validation}")
    private String name;
    @NotBlank(message="{Pattern.Person.notBlank.validation}")
    @Pattern(regexp="^[a-zA-Z]+$", message="{Pattern.Person.name.validation}")
    private String surname;
    @NotBlank(message="{Pattern.Person.notBlank.validation}")
    @Email(message="{Pattern.Person.email.validation}")
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
