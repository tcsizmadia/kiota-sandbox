package com.github.tcsizmadia.sandbox.kiota.services;

import com.github.tcsizmadia.sandbox.kiota.models.Quote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuoteService {

    List<Quote> getQuotes();

    List<Quote> getQuotesByAuthor(Long authorId);

    Quote upsertQuote(Quote quote);
}
