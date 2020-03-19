package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Models.Author;
import org.wcci.apimastery.Storages.Repositories.AuthorRepository;
import org.wcci.apimastery.Models.Book;
import org.wcci.apimastery.Storages.Repositories.BookRepository;

import java.util.Collection;

@RestController
@RequestMapping("authors")

public class AuthorController {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    @GetMapping("")
    public Collection<Author> retrieveAuthors(){
        return(Collection<Author>) authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author displaySingleAuthor (@PathVariable long id){
        return authorRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        Author authorToRemove = authorRepository.findById(id).get();

        for (Book bookToRemove : authorToRemove.getBooks()) {
            bookRepository.delete(bookToRemove);
        }
        authorRepository.deleteById(id);
    }

    @PostMapping("")
    public Author createAuthor(@RequestBody Author authorToAdd) {
        return authorRepository.save(authorToAdd);
    }

    @PatchMapping("/{id}/books")
    public Author updateAuthorBooks(@PathVariable Long id, @RequestBody Book requestBodyBook) {
        Author authorToPatch = authorRepository.findById(id).get();
        Book bookToAdd = new Book(requestBodyBook.getTitle(),authorToPatch, requestBodyBook.getGenre(),requestBodyBook.getPublishedDate(),requestBodyBook.getPublishingCompany());
        bookRepository.save(bookToAdd);
        return authorRepository.save(authorToPatch);
    }



}
