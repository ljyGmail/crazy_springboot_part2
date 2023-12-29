package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;
import reactor.core.publisher.Flux;

public interface BookCustomDao {
    Flux<Book> customQuery1(String regex, int startPrice);

    Flux<Book> customQuery2(int startPrice, int endPrice);
}
