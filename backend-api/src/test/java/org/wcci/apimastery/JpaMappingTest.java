package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.Models.Author;
import org.wcci.apimastery.Models.Book;
import org.wcci.apimastery.Storages.Repositories.AuthorRepository;
import org.wcci.apimastery.Storages.Repositories.BookRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaMappingTest {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void authorShouldHaveBooks(){

        Author testAuthor = new Author("test",20,"test");
        authorRepository.save(testAuthor);

        Book testBook1 = new Book("test",testAuthor,"test","test","test");
        Book testBook2 = new Book("test2",testAuthor,"test2","test2","test2");
        bookRepository.save(testBook1);
        bookRepository.save(testBook2);

        entityManager.flush();
        entityManager.clear();

        Author retrieveAuthor = authorRepository.findById(testAuthor.getId()).get();
        Book retrieveBook1 = bookRepository.findById(testBook1.getId()).get();
        Book retrieveBook2 = bookRepository.findById(testBook2.getId()).get();
        assertThat(retrieveAuthor.getBooks()).contains(retrieveBook1,retrieveBook2);
    }

}
