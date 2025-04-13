package br.com.thiagohmm.service;

import br.com.thiagohmm.exception.PersonNotFoundException;
import br.com.thiagohmm.model.Person;
import br.com.thiagohmm.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    private Logger log = LoggerFactory.getLogger(PersonService.class);

    public Person listByID(Long id) throws PersonNotFoundException {
        log.info("Finding one person by ID: {}", id);
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id)); // Use a custom exception
    }




    public Person create(Person person) {
      log.info("Creating a new person: {}", person);
        // Validate the person object before saving
        if (person.getFirstName() == null || person.getLastName() == null) {
           log.warn("First name and last name are required for creating a person.");

            throw new IllegalArgumentException("First name and last name are required.");
        }
        // Save the person to the database
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