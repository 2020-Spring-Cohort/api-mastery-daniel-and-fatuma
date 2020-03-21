package org.wcci.apimastery.Storages;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.Models.Author;
<<<<<<< HEAD:backend-api/src/main/java/org/wcci/apimastery/Storages/AuthorStorageJpaImpl.java
import org.wcci.apimastery.Storages.AuthorStorage;
import org.wcci.apimastery.Storages.Repositories.AuthorRepository;
=======
>>>>>>> 0320_DV:backend-api/src/main/java/org/wcci/apimastery/AuthorStorageJpaImpl.java

import java.util.Collection;

@Service
public class AuthorStorageJpaImpl implements AuthorStorage {
    AuthorRepository authorRepository;
    public AuthorStorageJpaImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public Collection<Author> getAll() {
        return (Collection<Author>) authorRepository.findAll();
    }
    @Override
    public void store(Author author) {
        authorRepository.save(author);
    }
    @Override
    public Author findAuthorByName(String name) {
        return authorRepository.findByName(name).get();
    }
    @Override
    public Author findAuthorById(long id) {
        return authorRepository.findById(id).get();
    }
    @Override
    public Author add(Author author) {
        authorRepository.save(author);
        return author;
    }
}