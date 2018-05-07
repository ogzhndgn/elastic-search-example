package org.thepoet;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.thepoet.elasticsearch.model.Book;
import org.thepoet.elasticsearch.service.BookService;

import java.util.Map;

@SpringBootApplication
public class ElasticSearchExampleApplication implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchExampleApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        printElasticSearchInfo();
        Book book = new Book();
        book.setId("1000");
        book.setTitle("Test Book for Elasticsearch");
        book.setAuthor("Oğuzhan Doğan");
        book.setCategory("Test Category");
        bookService.save(book);
        Page<Book> books = bookService.getByAuthor("Oğuzhan Doğan", PageRequest.of(0, 10));
        books.forEach(bookConsumer -> System.out.println(bookConsumer.toString()));
    }

    private void printElasticSearchInfo() {
        System.out.println("************************ Elasticsearch Info Started...");
        Client client = elasticsearchOperations.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("************************ Elasticsearch Info Finished.");
    }
}
