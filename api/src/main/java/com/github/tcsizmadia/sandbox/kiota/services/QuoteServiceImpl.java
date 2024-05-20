package com.github.tcsizmadia.sandbox.kiota.services;

import com.github.tcsizmadia.sandbox.kiota.models.Quote;
import com.github.tcsizmadia.sandbox.kiota.repositories.QuotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuotesRepository quotesRepository;

    public QuoteServiceImpl(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public List<Quote> getQuotes() {
        return this.quotesRepository.findAll();
    }

    @Override
    public List<Quote> getQuotesByAuthor(Long authorId) {
        return this.quotesRepository.findAllByAuthorId(authorId);
    }

    @Override
    public Quote upsertQuote(Quote quote) {
        return this.quotesRepository.save(quote);
    }
}
