package br.com.thiagohmm.controller;

import br.com.thiagohmm.model.Person;
import br.com.thiagohmm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Person getPersonById(@PathVariable("id") String idStr) {
        try {
            Long id = Long.parseLong(idStr);
            return personService.createPerson(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido: " + idStr);
        }
    }
}
