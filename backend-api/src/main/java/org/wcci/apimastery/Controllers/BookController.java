package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Models.Author;
import org.wcci.apimastery.Models.Book;
import org.wcci.apimastery.Storages.Repositories.AuthorRepository;
import org.wcci.apimastery.Storages.Repositories.BookRepository;

import java.util.Collection;


@RestController
@RequestMapping("books")
public class BookController {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    public Collection<Book> retrieveBooks() {
        return (Collection<Book>) bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book displaySingleBook(@PathVariable Long id){
        return bookRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);

    }
    @PostMapping("")
    public Book createBook(@RequestBody Book bookToAdd) {
        return bookRepository.save(bookToAdd);
    }

//    @PatchMapping("/{id}")
//    public Author updateAuthorBooks(@PathVariable Long id, @RequestBody Book requestBodyBook) {
//        Author authorToUpdate = authorRepository.findById(id).get();
//        Book bookToAdd = new Book(requestBodyBook.getTitle(),requestBodyBook.getAuthor(),requestBodyBook.getGenre(),requestBodyBook.getPublishedDate(),requestBodyBook.getPublishingCompany());
//        bookRepository.save(bookToAdd);
//        return authorRepository.save(authorToUpdate);
//    }

    @PatchMapping("/{id}/authors")
    public Book updateAuthorBook(@PathVariable Long id, @RequestBody Book requestBodyBook) {
        requestBodyBook.setId(id);
        return bookRepository.save(requestBodyBook);
    }


}
