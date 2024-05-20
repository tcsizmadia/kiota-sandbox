package com.github.tcsizmadia.sandbox.kiota.repositories;

import com.github.tcsizmadia.sandbox.kiota.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);
}