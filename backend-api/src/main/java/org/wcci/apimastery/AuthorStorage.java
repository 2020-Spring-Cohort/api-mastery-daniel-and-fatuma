package org.wcci.apimastery;

import java.util.Collection;

public interface AuthorStorage {
    Collection<Author> getAll();
    void store(Author author);
    Author findAuthorByName(String name);
    Author findAuthorById(long authorId);
    Author add(Author author);}
