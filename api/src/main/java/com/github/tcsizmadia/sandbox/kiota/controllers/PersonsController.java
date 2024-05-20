package com.github.tcsizmadia.sandbox.kiota.controllers;

import com.github.tcsizmadia.sandbox.kiota.models.Person;
import com.github.tcsizmadia.sandbox.kiota.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    private final PersonService personService;

    public PersonsController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "Get a list of all persons")
    @ApiResponse(
        responseCode = "200",
        description = "Persons are returned",
        content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Person.class)))
    )
    @GetMapping
    public List<Person> getPersons() {
        return this.personService.getPersons();
    }

    @Operation(summary = "Get a person by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "The person is returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
        @ApiResponse(responseCode = "404", description = "There is no person with the given ID")
    })
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Long id) {
        return this.personService.getPersonById(id).orElseThrow(NoSuchElementException::new);
    }

    @Operation(summary = "Adds a new person to the system, or updates it if it already exists")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "The person is created or updated"),
        @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping
    public Person upsertPerson(@RequestBody Person person) {
        return this.personService.upsertPerson(person);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoSuchElementException() {
        // This method is intentionally left blank
    }
}
