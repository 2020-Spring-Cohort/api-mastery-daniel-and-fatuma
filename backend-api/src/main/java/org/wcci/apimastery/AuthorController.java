package org.wcci.apimastery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Models.Author;
import org.wcci.apimastery.Storages.AuthorStorage;
import org.wcci.apimastery.Storages.Repositories.AuthorRepository;

import java.util.Collection;

@RestController
@RequestMapping("authors")

public class AuthorController {
    private AuthorRepository authorRepository;
    private AuthorStorage authorStorage;

    public AuthorController(AuthorRepository authorRepository, AuthorStorage authorStorage){
        this.authorRepository = authorRepository;
        this.authorStorage = authorStorage;
    }
    @GetMapping("")
    public Collection<Author> retrieveAuthors(){
        return(Collection<Author>) authorRepository.findAll();
    }
    @GetMapping("/{id}")
    public Author displaySingleAuthor ( @PathVariable long id){
        Author retrievedAuthor = authorStorage.findAuthorById(id);
        return retrievedAuthor;
    }

}
