package org.wcci.apimastery.Storages;

import org.wcci.apimastery.Models.Author;

import java.util.Collection;

public interface AuthorStorage {
    Collection<Author> getAll();
    void store(Author author);
    Author findAuthorByName(String name);
    Author findAuthorById(long authorId);
    Author add(Author author);}
