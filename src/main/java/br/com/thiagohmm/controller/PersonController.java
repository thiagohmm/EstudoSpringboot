package br.com.thiagohmm.controller;

import br.com.thiagohmm.model.Person;
import br.com.thiagohmm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Person getPersonById(@PathVariable("id") String idStr) {
        try {
            Long id = Long.parseLong(idStr);
            return personService.listByID(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido: " + idStr);
        }
    }

    @GetMapping(produces = "application/json")
    public List<Person> getAllPerson() {
        return personService.listAll();
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public Person createPerson(@RequestBody Person person) {
        if (person.getFirstName() == null || person.getLastName() == null) {
            throw new IllegalArgumentException("Nome e sobrenome são obrigatórios.");
        }
        return personService.create(person);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletePerson(@PathVariable("id") String idStr) {
        try {
            Long id = Long.parseLong(idStr);
            personService.delete(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido: " + idStr);
        }
    }

    @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public Person updatePerson(@RequestBody Person person) {
        if (person.getId() == null) {
            throw new IllegalArgumentException("ID é obrigatório para atualização.");
        }
        return personService.update(person);
    }
}
