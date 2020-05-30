package com.java.bootcamp.projects.spring.springjunit.controller;

import com.java.bootcamp.projects.spring.springjunit.dto.Book;
import com.java.bootcamp.projects.spring.springjunit.dto.ObjectKey;
import com.java.bootcamp.projects.spring.springjunit.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    private final CacheService cacheService;

    public BookController(@Autowired CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping
    public ResponseEntity<ObjectKey> addBook(@RequestBody Book book) {
        LOG.info("addBook: {}", book.getName());
        ObjectKey objectKey = ObjectKey.random();
        cacheService.put(objectKey,  book);
        return ResponseEntity.ok(objectKey);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ObjectKey> deleteBook(@PathVariable(value="id") String id) {
        LOG.info("deleteBook: {}", id);
        ObjectKey objectKey = ObjectKey.from(id);
        cacheService.remove(objectKey);
        return ResponseEntity.ok(objectKey);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable(value="id") String id) {
        LOG.info("getBook: {}", id);
        ObjectKey objectKey = ObjectKey.from(id);
        Optional<Book> optionalBook = cacheService.get(objectKey, Book.class);
        return ResponseEntity.of(optionalBook);
    }

    @GetMapping
    public ResponseEntity<Collection<Book>> getBooks() {
        LOG.info("getBooks:");
        Collection<Book> books = cacheService.get(Book.class);
        return ResponseEntity.ok(books);
    }

}
