package br.com.thiagohmm.service;

import br.com.thiagohmm.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person createPerson(Long id) {
        Person obj = new Person();
        obj.setId(id);
        obj.setFirstName("Thiago");
        obj.setLastName("HMM");
        obj.setAddress("Rua 1");
        obj.setEmail("thiagohmm@gmail.com");
        obj.setAge(39);
        return obj;
    }
}
