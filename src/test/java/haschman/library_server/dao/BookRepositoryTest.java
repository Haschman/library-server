package haschman.library_server.dao;

import haschman.library_server.domain.Author;
import haschman.library_server.domain.Book;
import haschman.library_server.domain.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    LocationRepository locationRepository;

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        locationRepository.deleteAll();
    }

    @Test
    void findBooksByAuthor() {
        Location location1 = new Location(1L, 1, 1);
        locationRepository.save(location1);

        Author author1 = new Author(1L, "One", "One", null, null);
        Author author2 = new Author(2L, "Two", "Two", null, null);
        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book1 = new Book(1L, "Book One", "EN", null, null, null, null, Set.of(author1), location1);
        Book book2 = new Book(2L, "Book Two", "EN", null, null, null, null, Set.of(author2), location1);
        Book book3 = new Book(3L, "Book Three", "EN", null, null, null, null, Set.of(author1, author2), location1);
        Book book4 = new Book(4L, "Book Four", "EN", null, null, null, null, Set.of(author2, author1), location1);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);

        Assertions.assertEquals(bookRepository.findBooksByAuthor(author1.getId()), List.of(book1, book3, book4));
    }

    @Test
    void findBooksFromLocation() {
        Location location1 = new Location();
        location1.setShelf(1);
        location1.setShelf(1);
        Location location2 = new Location();
        location2.setShelf(1);
        location2.setShelf(2);
        Location location3 = new Location();
        location3.setShelf(1);
        location3.setShelf(3);
        locationRepository.save(location1);
        locationRepository.save(location2);
        locationRepository.save(location3);

        Author author1 = new Author("One", "One", null, null);
        authorRepository.save(author1);

        Book book1 = new Book(1L, "Book One", "EN", null, null, null, null, Set.of(author1), location1);
        Book book2 = new Book(2L, "Book Two", "EN", null, null, null, null, Set.of(author1), location2);
        Book book3 = new Book(3L, "Book Three", "EN", null, null, null, null, Set.of(author1), location2);
        Book book4 = new Book(4L, "Book Four", "EN", null, null, null, null, Set.of(author1), location3);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);

        Assertions.assertEquals(bookRepository.findBooksFromLocation(location2.getId()), List.of(book2, book3));
    }
}
