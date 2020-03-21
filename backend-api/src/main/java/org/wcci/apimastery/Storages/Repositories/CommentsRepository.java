package org.wcci.apimastery.Storages.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Models.Comments;

public interface CommentsRepository extends CrudRepository<Comments, Long> {
}
