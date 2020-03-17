package org.wcci.apimastery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("authors")

public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @GetMapping("")
    public Collection<Author> retrieveAuthors(){
        return(Collection<Author>) authorRepository.findAll();
    }

}
