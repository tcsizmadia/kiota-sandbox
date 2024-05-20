package com.github.tcsizmadia.sandbox.kiota.models;

import com.github.tcsizmadia.sandbox.kiota.repositories.PersonRepository;
import com.github.tcsizmadia.sandbox.kiota.repositories.QuotesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final String WINSTON_CHURCHILL = "Winston Churchill";
    private static final String WOODY_ALLEN = "Woody Allen";
    private static final String ALBERT_EINSTEIN = "Albert Einstein";
    private static final String MARGARET_THATCHER = "Margaret Thatcher";
    private static final String MERYL_STREEP = "Meryl Streep";
    private static final String TAYLOR_SWIFT = "Taylor Swift";

    private static final Map<String, List<String>> quotes = new HashMap<>(6);

    static {
        quotes.put(
            WINSTON_CHURCHILL,
            Arrays.asList(
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "The price of greatness is responsibility.",
                "Success consists of going from failure to failure without loss of enthusiasm."
            )
        );

        quotes.put(
            WOODY_ALLEN,
            Arrays.asList(
                "I'm not afraid of death; I just don't want to be there when it happens.",
                "Eighty percent of success is showing up.",
                "If you're not failing every now and again, it's a sign you're not doing anything very innovative."
            )
        );

        quotes.put(
            ALBERT_EINSTEIN,
            Arrays.asList(
                "The only source of knowledge is experience.",
                "Imagination is more important than knowledge.",
                "The true sign of intelligence is not knowledge but imagination."
            )
        );

        quotes.put(
            MARGARET_THATCHER,
            Arrays.asList(
                "You may have to fight a battle more than once to win it.",
                "If you want something said, ask a man; if you want something done, ask a woman.",
                "I always cheer up immensely if an attack is particularly wounding because I think, well, " +
                "if they attack one personally, it means they have not a single political argument left."
            )
        );

        quotes.put(
            MERYL_STREEP,
            Arrays.asList(
                "The great gift of human beings is that we have the power of empathy.",
                "Acting is not about being someone different. It's finding the similarity in what is apparently " +
                "different, then finding myself in there.",
                "Integrate what you believe in every single area of your life. Take your heart to work and ask the " +
                "most and best of everybody else, too."
            )
        );

        quotes.put(
            TAYLOR_SWIFT,
            Arrays.asList(
                "People haven't always been there for me but music always has.",
                "Life isn't how to survive the storm, it's about how to dance in the rain.",
                "Unique and different is the new generation of beautiful. You don't have to be like everyone else."
            )
        );
    }

    private final PersonRepository personRepository;
    private final QuotesRepository quotesRepository;

    public DataInitializer(PersonRepository personRepository, QuotesRepository quotesRepository) {
        this.personRepository = personRepository;
        this.quotesRepository = quotesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        personRepository.deleteAll();
        personRepository.save(new Person(WINSTON_CHURCHILL, Occupation.POLITICIAN));
        personRepository.save(new Person(WOODY_ALLEN, Occupation.ACTOR));
        personRepository.save(new Person(ALBERT_EINSTEIN, Occupation.SCIENTIST));
        personRepository.save(new Person(MARGARET_THATCHER, Occupation.POLITICIAN));
        personRepository.save(new Person(MERYL_STREEP, Occupation.ACTOR));
        personRepository.save(new Person(TAYLOR_SWIFT, Occupation.MUSICIAN));

        personRepository.findAll().forEach(this::addQuotes);
    }

    private void addQuotes(Person person) {
        quotes.computeIfAbsent(person.getName(), k -> Collections.emptyList())
            .forEach(quote -> quotesRepository.save(new Quote(person, quote)));
    }
}
