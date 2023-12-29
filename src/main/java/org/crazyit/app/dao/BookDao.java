package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BookDao extends ReactiveCrudRepository<Book, Long>,
        ReactiveQueryByExampleExecutor<Book>, BookCustomDao {
    // Like关键字只使用简单的通配符
    Flux<Book> findByTitleLike(String titlePattern);

    // Regex(或Matches)进行正则表达式匹配
    Flux<Book> findByTitleMatches(String regex);

    Flux<Book> findByTitleContains(String subTitle);

    Flux<Book> findByPriceBetween(double start, double end);

    @Query("MATCH (b :Book) - [:WRITTEN_BY] -> () WHERE " +
            "b.price >= $0 AND b.price <= $1 RETURN b ")
    Flux<Book> findByQuery1(double start, double end);

    @Query("MATCH (b :Book) - [:WRITTEN_BY] -> () " +
            "WHERE b.title =~ $0 RETURN b")
    Flux<Book> findByQuery2(String titlePattern);
}
