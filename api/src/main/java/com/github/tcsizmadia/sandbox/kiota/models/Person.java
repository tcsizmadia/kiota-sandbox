package com.github.tcsizmadia.sandbox.kiota.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Represents a person who can be an author of a {@link Quote}.
 * <p>
 * The person has a name and an occupation.
 * @author Tamas Csizmadia
 */
@Entity
public class Person {
    @Schema(description = "The unique identifier of the person.", example = "1")
    @Id
    @GeneratedValue
    private Long id;

    @Schema(description = "The name of the person.", example = "John Doe")
    private String name;

    @Schema(description = "The occupation of the person.", example = "ACTOR")
    private Occupation occupation;

    public Person(String name, Occupation occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
}
