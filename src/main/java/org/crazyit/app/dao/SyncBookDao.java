package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface SyncBookDao extends CrudRepository<Book, String>,
        QueryByExampleExecutor<Book>, SyncBookCustomDao {
    // like运算符使用简单的通配符: *
    List<Book> findByNameLike(String namePattern);

    // Regex进行正则表达式匹配
    List<Book> findByNameRegex(String regex);

    List<Book> findByDescriptionContains(String subDesc);

    List<Book> findByPriceBetween(double start, double end);

    @Query("{price: {$gt: ?0, $lt: ?1}}")
    List<Book> findByQuery1(double start, double end);

    @Query("{name: {$regex: ?0}}")
    List<Book> findByQuery2(String namePattern);
}
