package org.crazyit.app.dao;

import org.crazyit.app.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface SyncAuthorDao extends CrudRepository<Author, Long> {

    Author findByName(String name);
}
