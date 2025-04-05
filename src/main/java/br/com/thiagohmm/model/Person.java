package br.com.thiagohmm.model;

import br.com.thiagohmm.service.PersonService;
import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(generator = "sequence")

    private  Long id;
    @Column (name = "FIRST_NAME" , nullable = false, length = 50)
    private  String firstName;
    @Column (name = "LAST_NAME", nullable = false, length = 50)
    private  String lastName;
    @Column(name = "EMAIL" , unique = true, nullable = false , length = 100)
    private  String email;
    @Column (name = "AGE" , nullable = false , length = 3)
    private  Integer age;
    @Column (name = "ADDRESS" , nullable = false , length = 200)
    private  String address;

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email) && Objects.equals(age, person.age) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, age, address);
    }
}
