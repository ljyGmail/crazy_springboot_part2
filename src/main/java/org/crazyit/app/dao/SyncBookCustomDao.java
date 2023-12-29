package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;

import java.util.List;

public interface SyncBookCustomDao {
    List<Book> customQuery1(String regex, int startPrice);

    List<Book> customQuery2(int startPrice, int endPrice);
}
