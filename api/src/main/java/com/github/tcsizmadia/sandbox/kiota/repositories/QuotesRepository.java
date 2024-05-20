package com.github.tcsizmadia.sandbox.kiota.repositories;

import com.github.tcsizmadia.sandbox.kiota.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quote, Long> {
    List<Quote> findAllByAuthorId(Long authorId);
}
