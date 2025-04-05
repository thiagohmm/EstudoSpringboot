package br.com.thiagohmm.repository;

import br.com.thiagohmm.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {}
