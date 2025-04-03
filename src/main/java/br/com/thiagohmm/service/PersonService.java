package br.com.thiagohmm.service;

import br.com.thiagohmm.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public Person listByID(Long id) {
        Person obj = new Person();
        obj.setId(id);
        obj.setFirstName("Thiago");
        obj.setLastName("HMM");
        obj.setAddress("Rua 1");
        obj.setEmail("thiagohmm@gmail.com");
        obj.setAge(39);
        return obj;
    }


    public Person create(Person person) {
        // Simulate saving the person to a database
        // In a real application, you would use a repository to save the person
        return person;
    }

    public List<Person> listAll() {
        // Simulate listing all persons
        // In a real application, you would use a repository to fetch all persons
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId((long) i +1);
            person.setFirstName("Person " + i);
            person.setLastName("Last " + i);
            person.setEmail("person" + i + "@example.com");
            person.setAge(20 + i);
            person.setAddress("Address " + i);
            persons.add(person);
        }
       return persons;
    }


    public void delete(Long id) {
        // Simulate deleting a person by ID
        // In a real application, you would use a repository to delete the person
        System.out.println("Person with ID " + id + " deleted.");
    }


    public Person update(Person person) {
        // Simulate updating a person
        // In a real application, you would use a repository to update the person
        return person;
    }
}
