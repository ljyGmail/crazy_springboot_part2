package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;

import java.util.List;

public interface SyncBookCustomDao {
    List<Book> customQuery1(String regex, double startPrice);

    List<Book> customQuery2(double startPrice, double endPrice);
}
