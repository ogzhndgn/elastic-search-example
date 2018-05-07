package org.thepoet.elasticsearch.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.thepoet.elasticsearch.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 6.05.2018
 */
public interface BookService {
    Book save(Book book);

    void delete(Book book);

    Optional<Book> getById(String id);

    Iterable<Book> getAll();

    Page<Book> getByAuthor(String author, PageRequest pageRequest);

    List<Book> getByTitle(String title);
}
