package org.thepoet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.SpringVersion;

@SpringBootApplication
//public class ElasticSearchExampleApplication implements CommandLineRunner {
public class ElasticSearchExampleApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ElasticSearchExampleApplication.class);
    }

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("The Poet's Elasticsearch Test Application");
        System.out.println("Spring Version is: " + SpringVersion.getVersion());
        System.out.println("****************************************");
        SpringApplication.run(ElasticSearchExampleApplication.class, args);
    }

//    @Autowired
//    private ElasticsearchOperations elasticsearchOperations;
//
//    @Autowired
//    private BookService bookService;
//
//    public static void main(String[] args) {
//        SpringApplication.run(ElasticSearchExampleApplication.class, args);
//    }
//
//    @Override
//    public void run(String... strings) throws Exception {
//        printElasticSearchInfo();
//        Book book = new Book();
//        book.setId("1000");
//        book.setTitle("Test Book for Elasticsearch");
//        book.setAuthor("Oğuzhan Doğan");
//        book.setCategory("Test Category");
//        bookService.save(book);
//        Page<Book> books = bookService.getByAuthor("Oğuzhan Doğan", PageRequest.of(0, 10));
//        books.forEach(bookConsumer -> System.out.println(bookConsumer.toString()));
//    }
//
//    private void printElasticSearchInfo() {
//        System.out.println("************************ Elasticsearch Info Started...");
//        Client client = elasticsearchOperations.getClient();
//        Map<String, String> asMap = client.settings().getAsMap();
//        asMap.forEach((k, v) -> {
//            System.out.println(k + " = " + v);
//        });
//        System.out.println("************************ Elasticsearch Info Finished.");
//    }
}
