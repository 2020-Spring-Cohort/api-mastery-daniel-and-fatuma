package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthorControllerTest {

    private AuthorRepository authorRepository;
    private AuthorController underTest;
    private Author testAuthor;

    @Test
    public void retrieveAuthorsReturnListOfAuthorsFromMockRepo(){
        authorRepository = mock(AuthorRepository.class);
        AuthorController underTest = new AuthorController(authorRepository);
        Author testAuthor = new Author("testName", 2,"testTown");
        when(authorRepository.findAll()).thenReturn(Collections.singletonList(testAuthor));
        Collection<Author> result = underTest.retrieveAuthors();
        verify(authorRepository).findAll();
    }
    @Test
    public void authorsShouldReturnListOfAuthors(){
        authorRepository = mock(AuthorRepository.class);
        AuthorController underTest = new AuthorController(authorRepository);
        Author testAuthor = new Author("testName", 12, "testTown");
        when(authorRepository.findAll()).thenReturn(Collections.singletonList(testAuthor));
        Collection<Author> result = underTest.retrieveAuthors();
        assertThat(result).contains(testAuthor);
    }
    @Test
    public void authorsIsWiredCorrectly() throws Exception{
        authorRepository = mock(AuthorRepository.class);
        AuthorController underTest = new AuthorController(authorRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/authors")).andExpect(status().isOk());
    }





}
