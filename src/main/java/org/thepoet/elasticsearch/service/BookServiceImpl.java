package org.thepoet.elasticsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.thepoet.elasticsearch.dao.BookDao;
import org.thepoet.elasticsearch.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 6.05.2018
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    public Optional<Book> getById(String id) {
        return bookDao.findById(id);
    }

    @Override
    public Iterable<Book> getAll() {
        return bookDao.findAll();
    }

    @Override
    public Page<Book> getByAuthor(String author, PageRequest pageRequest) {
        return bookDao.findByAuthor(author, pageRequest);
    }

    @Override
    public List<Book> getByTitle(String title) {
        return bookDao.findByTitle(title);
    }
}