package org.thepoet.elasticsearch.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.thepoet.elasticsearch.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 6.05.2018
 */
public interface BookDao extends ElasticsearchRepository<Book, String> {

    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);

    Optional<Book> findById(String id);
}