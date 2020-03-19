package org.wcci.apimastery.Storages.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Models.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author,Long> {


    Optional<Author> findByName(String name);
}
