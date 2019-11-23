package com.java.bootcamp.projects.lambdas.tests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LambdaDemosTests {

    private static final Logger LOG = LoggerFactory.getLogger(LambdaDemosTests.class);

    @Test
    public void newAutoCloseableFunctional() throws Exception {
        AtomicInteger ai = new AtomicInteger(0);

        AutoCloseable closeable = () -> {
            LOG.info("closing functional ...");
            ai.incrementAndGet();
        };

        closeable.close();
        assertTrue(ai.get() == 1);
    }

    @Test
    public void newAutoCloseableAnonymousClass() throws Exception {
        AtomicInteger ai = new AtomicInteger(0);

        AutoCloseable closeable = new AutoCloseable() {
            @Override
            public void close() throws Exception {
                LOG.info("closing anonymous class...");
                ai.incrementAndGet();
            }
        };

        closeable.close();
        assertTrue(ai.get() == 1);
    }

    @Test
    public void printWordsTest() {
        List<String> words = getWords();
        words.forEach(w->{
            LOG.info("word: {}", w);
        });
    }

    @Test
    public void filterWordsTest() {
        List<String> words = getWords();
        List<String> wordsFiltered = words.stream().filter(w -> w.startsWith("J")).collect(Collectors.toList());
        assertTrue(wordsFiltered.size() == 3);
    }

    @Test
    public void filterWordsFindFirstTest() {
        List<String> words = getWords();
        Optional<String> first = words.stream().filter(w -> w.startsWith("J")).findFirst();
        assertTrue(first.isPresent());
    }

    private static List<String> getWords() {
        List<String> words = new ArrayList<>();
        words.add("John");
        words.add("Jane");
        words.add("Black");
        words.add("Jack");
        words.add("Whiskey");
        return words;
    }

}
