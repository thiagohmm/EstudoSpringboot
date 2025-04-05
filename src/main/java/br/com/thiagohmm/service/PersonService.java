package br.com.thiagohmm.service;

import br.com.thiagohmm.exception.PersonNotFoundException;
import br.com.thiagohmm.model.Person;
import br.com.thiagohmm.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person listByID(Long id) throws PersonNotFoundException {

        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id)); // Use a custom exception
    }




    public Person create(Person person) {
       return personRepository.save(person);

    }

    public List<Person> listAll() {

        return personRepository.findAll();
    }


    public void delete(Long id) throws PersonNotFoundException {

        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            personRepository.delete(personOptional.get());
        } else {
            throw new PersonNotFoundException("Person not found with id: " + id);
        }

    }



    public Person update(Person personWithUpdates) {
        // 1. Find the existing person by ID
        // Use the ID from the person object containing the updates
        Long idToUpdate = personWithUpdates.getId();
        if (idToUpdate == null) {
            // Or handle as appropriate for your application
            throw new IllegalArgumentException("Person ID cannot be null for update.");
        }

        Person existingPerson = null; // Correctly use the ID
        try {
            existingPerson = personRepository.findById(idToUpdate)
                    .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + idToUpdate));
        } catch (PersonNotFoundException e) {
            throw new RuntimeException(e);
        }



        existingPerson.setFirstName(personWithUpdates.getFirstName()); // Example field
        existingPerson.setLastName(personWithUpdates.getLastName());
        existingPerson.setAge(personWithUpdates.getAge());
        existingPerson.setAddress(personWithUpdates.getAddress());

        Person updatedPerson = personRepository.save(existingPerson);

        // 4. Return the updated and persisted person object
        return updatedPerson;
    }
}