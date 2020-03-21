package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Models.Author;
import org.wcci.apimastery.Models.Book;

import org.wcci.apimastery.Storages.Repositories.AuthorRepository;
import org.wcci.apimastery.Storages.Repositories.BookRepository;


@Component
public class Populator implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        Author testAuthor1 = new Author("testName1",56,"TestTown1");
        authorRepository.save(testAuthor1);
        Author testAuthor2 = new Author("testName2",57,"TestTown2");
        authorRepository.save(testAuthor2);
        Author testAuthor3 = new Author("testName3",58,"TestTown3");
        authorRepository.save(testAuthor3);

        Book testBook1 = new Book("testTitle", testAuthor1, "TestGenre", "13march2020", "PubCo");
        bookRepository.save(testBook1);
        Book testBook2 = new Book("testTitle", testAuthor2, "TestGenre", "13march2020", "PubCo");
        bookRepository.save(testBook2);
        Book testBook3 = new Book("testTitle", testAuthor3, "TestGenre", "13march2020", "PubCo");
        bookRepository.save(testBook3);

    }
}
