package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.Models.Author;
import org.wcci.apimastery.Models.Book;

import org.wcci.apimastery.Storages.Repositories.AuthorRepository;
import org.wcci.apimastery.Storages.Repositories.BookRepository;
import org.wcci.apimastery.Models.Rating;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaMappingTest {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Author testAuthor;
    private Book testBook1;
    private Book testBook2;
//    private Comment testComment;
//    private Comment testComment2;


    @BeforeEach
    void setUp() {
        testAuthor = new Author("Test", 25, "Town");
        authorRepository.save(testAuthor);

        testBook1 = new Book("Thriller", testAuthor, "s", "Test date", "Test Co");
        testBook2 = new Book("bad" , testAuthor, "ss", "Test date", "Test Inc");
        bookRepository.save(testBook1);
        bookRepository.save(testBook2);

//        testComment = new Comment("commenter name","Comment body");
////        commentRepo.save(testComment);
////        testComment2 = new Comment("commenter name", "CommentBody");
////        commentRepo.save(testComment2);
    }


    @Test
    public void authorShouldHaveBooks(){

        testAuthor = new Author("test",20,"test");
        authorRepository.save(testAuthor);

        testBook1 = new Book("test",testAuthor,"test","test","test");
        testBook2 = new Book("test2",testAuthor,"test2","test2","test2");
        bookRepository.save(testBook1);
        bookRepository.save(testBook2);

        entityManager.flush();
        entityManager.clear();

        Author retrieveAuthor = authorRepository.findById(testAuthor.getId()).get();
        Book retrieveBook1 = bookRepository.findById(testBook1.getId()).get();
        Book retrieveBook2 = bookRepository.findById(testBook2.getId()).get();
        assertThat(retrieveAuthor.getBooks()).contains(retrieveBook1,retrieveBook2);
    }
    @Test
    public void authorShouldHaveUpRating(){
        testAuthor.addUpRating();
        Rating ratingToTest = testAuthor.getRating();
        assertThat(ratingToTest.getUpRating()).isEqualTo(1);
    }
    @Test
    public void authorShouldHaveDownRating(){
        testAuthor.addDownRating();
        Rating ratingToTest = testAuthor.getRating();
        assertThat(ratingToTest.getDownRating()).isEqualTo(1);
    }
    @Test
    public void bookShouldHaveUpRating(){
        testBook1.addUpRating();
        Rating ratingToTest = testBook1.getRating();
        assertThat(ratingToTest.getUpRating()).isEqualTo(1);
    }
    @Test
    public void bookShouldHaveDownRating(){
        testBook1.addDownRating();
        Rating ratingToTest = testBook1.getRating();
        assertThat(ratingToTest.getDownRating()).isEqualTo(1);
    }


}
