package com.java.bootcamp.projects.spring.springjunit;

import com.java.bootcamp.projects.spring.springjunit.dto.Book;
import com.java.bootcamp.projects.spring.springjunit.dto.ObjectKey;
import com.java.bootcamp.projects.spring.springjunit.dto.SystemInfo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RESTApplicationTest {

    private static final Map<ObjectKey, Book> books = new HashMap<>();
    private static ObjectKey bookKey1;
    private static ObjectKey bookKey2;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    public void testGetBooksInit() throws MalformedURLException {
        checkBooks(0);
    }

    @Test
    @Order(2)
    public void addFirstBook() throws MalformedURLException {
        Book book = new Book("Harry Potter", "J. K. Rowling", 120L);
        bookKey1 = addBook(book);
        checkBooks(1);
    }

    @Test
    @Order(3)
    public void addSecondBook() throws MalformedURLException {
        Book book = new Book("Effective Java", "Joshua Bloch", 120L);
        bookKey2 = addBook(book);
        checkBooks(2);
    }

    @Test
    @Order(4)
    public void getFirstBook() throws MalformedURLException {
        getAndCheckBook(bookKey1);
    }

    @Test
    @Order(5)
    public void getSecondBook() throws MalformedURLException {
        getAndCheckBook(bookKey2);
    }

    @Test
    @Order(6)
    public void removeFirstBook() throws MalformedURLException {
        removeBook(bookKey1);
        checkBooks(1);
    }

    @Test
    @Order(7)
    public void removeSecondBook() throws MalformedURLException {
        removeBook(bookKey2);
        checkBooks(0);
    }

    @Test
    @Order(8)
    public void testSystemInfo() throws MalformedURLException {
        ResponseEntity<SystemInfo> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/system/info").toString(), SystemInfo.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        SystemInfo systemInfo = response.getBody();
        assertNotNull(systemInfo);
        assertNotNull(systemInfo.getAppName());
        assertNotNull(systemInfo.getTimeStamp());
        assertNotNull(systemInfo.getAppId());
    }

    private ObjectKey addBook(Book book) throws MalformedURLException {
        ResponseEntity<ObjectKey> response = restTemplate.postForEntity(new URL("http://localhost:" + port + "/books").toString(), book, ObjectKey.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        ObjectKey bookKey = response.getBody();
        assertNotNull(bookKey);
        books.put(bookKey, book);
        return bookKey;
    }

    private void removeBook(ObjectKey objectKey) throws MalformedURLException {
        restTemplate.delete(new URL("http://localhost:" + port + "/books/" + objectKey.getKey()).toString());
    }

    private void checkBooks(int expectedNumberOfBooks) throws MalformedURLException {
        ResponseEntity<Book[]> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/books").toString(), Book[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(expectedNumberOfBooks, response.getBody().length);
    }

    private void getAndCheckBook(ObjectKey objectKey) throws MalformedURLException {
        ResponseEntity<Book> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/books/" + objectKey.getKey()).toString(), Book.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Book cachedBook = response.getBody();
        Book book = books.get(objectKey);
        assertEquals(cachedBook.getAuthor(), book.getAuthor());
        assertEquals(cachedBook.getName(), book.getName());
        assertEquals(cachedBook.getPrice(), book.getPrice());
    }

}
