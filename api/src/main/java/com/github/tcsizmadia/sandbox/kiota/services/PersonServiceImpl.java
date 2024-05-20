package com.github.tcsizmadia.sandbox.kiota.services;

import com.github.tcsizmadia.sandbox.kiota.models.Person;
import com.github.tcsizmadia.sandbox.kiota.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        return this.personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return this.personRepository.findById(id);
    }

    @Override
    public Person upsertPerson(Person person) {
        return null;
    }
}
