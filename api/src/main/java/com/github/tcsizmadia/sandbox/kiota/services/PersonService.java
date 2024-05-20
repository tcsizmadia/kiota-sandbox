package com.github.tcsizmadia.sandbox.kiota.services;

import com.github.tcsizmadia.sandbox.kiota.models.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {
    List<Person> getPersons();

    Optional<Person> getPersonById(Long id);

    Person upsertPerson(Person person);
}
