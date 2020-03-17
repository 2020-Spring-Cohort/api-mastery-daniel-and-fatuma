package org.wcci.apimastery;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/authors")
    public Collection<Author> retrieveAuthors(){
        return(Collection<Author>) authorRepository.findAll();
    }
}
