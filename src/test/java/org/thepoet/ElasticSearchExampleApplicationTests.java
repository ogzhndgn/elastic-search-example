package org.thepoet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thepoet.elasticsearch.model.Book;
import org.thepoet.elasticsearch.service.BookService;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchExampleApplicationTests {

    @Autowired
    private BookService bookService;

    private Book expectedBook;
    private Book toBeDeleted;

    @Before
    public void doBefore() {
        expectedBook = this.getExpectedBook();
        toBeDeleted = this.getToBeDeleted();
    }

    @Test
    public void shouldSaveBook() {
        Book actualBook = bookService.save(expectedBook);
        assertNotNull(actualBook.getId());
        assertEquals(actualBook.getAuthor(), expectedBook.getAuthor());
        assertEquals(actualBook.getTitle(), expectedBook.getTitle());
    }

    @Test
    public void shouldGetById() {
        Optional<Book> actualBook = bookService.getById("14");
        assertEquals(expectedBook.getTitle(), actualBook.isPresent() ? actualBook.get().getTitle() : "");
        assertEquals(expectedBook.getAuthor(), actualBook.isPresent() ? actualBook.get().getAuthor() : "");
        assertEquals(expectedBook.getCategory(), actualBook.isPresent() ? actualBook.get().getCategory() : "");
    }

    @Test
    public void shouldGetByTitle() {
        List<Book> actualBookList = bookService.getByTitle("Marslı");
        assertEquals(1, actualBookList.size());
        Book actualBook = actualBookList.get(0);
        assertEquals(expectedBook.getTitle(), actualBook.getTitle());
        assertEquals(expectedBook.getCategory(), actualBook.getCategory());
        assertEquals(expectedBook.getAuthor(), actualBook.getAuthor());
    }

    @Test
    public void shouldDeleteBook() {
        Book savedBook = bookService.save(toBeDeleted);
        bookService.delete(savedBook);
        Optional<Book> foundBook = bookService.getById(toBeDeleted.getId());
        assertNull(foundBook.orElse(null));
    }

    private Book getExpectedBook() {
        Book book = new Book();
        book.setId("14");
        book.setTitle("Marslı");
        book.setCategory("Bilim Kurgu");
        book.setAuthor("Andy Weir");
        return book;
    }

    private Book getToBeDeleted() {
        Book book = new Book();
        book.setId("1001");
        book.setCategory("DELETED");
        book.setAuthor("AUTHOR DELETED");
        book.setTitle("TITLE DELETED");
        return book;
    }
}