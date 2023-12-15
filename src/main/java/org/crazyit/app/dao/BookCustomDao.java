package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookCustomDao {
    void hmset(String key, Map<String, String> hash);

    List<Book> customQuery(double startPrice);
}
