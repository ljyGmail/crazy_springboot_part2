package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BookDao extends ReactiveCrudRepository<Book, String>,
        ReactiveQueryByExampleExecutor<Book>, BookCustomDao {
    // Like关键字只能用简单的通配符: *
    Flux<Book> findByNameLike(String namePattern);

    // Regex进行正则表达式匹配
    Flux<Book> findByNameRegex(String regex);

    Flux<Book> findByDescriptionContains(String subDesc);

    Flux<Book> findByPriceBetween(double start, double end);

    @Query("{price: {$gt:  ?0, $lt:  ?1}}")
    Flux<Book> findByQuery1(double start, double end);

    @Query("{name: {$regex: ?0}}")
    Flux<Book> findByQuery2(String namePattern);
}
