package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface BookDao extends CrudRepository<Book, Integer>, QueryByExampleExecutor<Book>, BookCustomDao {
    List<Book> findByName(String name);

    List<Book> findByDescription(String subDesc);
}
