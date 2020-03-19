package org.wcci.apimastery.Storages.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Models.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
