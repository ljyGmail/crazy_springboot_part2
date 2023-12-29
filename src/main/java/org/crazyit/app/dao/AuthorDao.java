package org.crazyit.app.dao;

import org.crazyit.app.domain.Author;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface AuthorDao extends ReactiveCrudRepository<Author, Long> {
    Mono<Author> findByName(String name);
}
