package com.github.tcsizmadia.sandbox.kiota.controllers;

import com.github.tcsizmadia.sandbox.kiota.models.Quote;
import com.github.tcsizmadia.sandbox.kiota.services.QuoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quotes")
class QuotesController {
    private final QuoteService quoteService;

    public QuotesController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @Operation(summary = "Get a list of all quotes")
    @ApiResponse(
        responseCode = "200",
        description = "Quotes are returned",
        content = @Content(
            mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Quote.class))
        )
    )
    @GetMapping
    public List<Quote> getQuotes() {
        return this.quoteService.getQuotes();
    }

    @Operation(summary = "Get all the quotes by an author")
    @ApiResponse(
        responseCode = "200",
        description = "Quotes are returned",
        content = @Content(
            mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Quote.class))
        )
    )
    @GetMapping("/author/{authorId}")
    public List<Quote> getQuotesByAuthor(@PathVariable("authorId") Long authorId) {
        return this.quoteService.getQuotesByAuthor(authorId);
    }
}