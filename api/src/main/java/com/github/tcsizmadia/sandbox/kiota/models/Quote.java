package com.github.tcsizmadia.sandbox.kiota.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Represents a quote.
 * <p>
 * The quote has an author and the quote (aka content) itself.
 * @author Tamas Csizmadia
 */
@Entity
public class Quote {
    @Schema(description = "The unique identifier of the quote.", example = "1")
    @Id
    @GeneratedValue
    private Long id;

    @Schema(description = "The author of the quote - a Person entity", example = "John Doe")
    @ManyToOne(targetEntity = Person.class)
    private Person author;

    @Schema(description = "The content of the quote.", example = "To be or not to be, that is the question.")
    private String content;

    public Quote(Person author, String content) {
        this.author = author;
        this.content = content;
    }

    public Quote() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
