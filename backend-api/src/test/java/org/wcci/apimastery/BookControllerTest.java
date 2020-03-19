package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Controllers.BookController;
import org.wcci.apimastery.Models.Author;
import org.wcci.apimastery.Models.Book;
import org.wcci.apimastery.Storages.Repositories.BookRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookControllerTest {


    private BookController underTest;

    @BeforeEach
    void setUp(){
        BookRepository bookRepository = mock(BookRepository.class);
        underTest = new BookController(bookRepository);
        Author testAuthor = new Author("test",20,"test");
        Book testBook = new Book("test", testAuthor, "test", "test", "test");
        when(bookRepository.findAll()).thenReturn(Collections.singletonList(testBook));
    }
    @Test
    public void underTestIsWiredCorrectlyWithoutAnnotations() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }

}
