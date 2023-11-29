package org.crazyit.app.service;

import org.crazyit.app.domain.Book;

import java.util.Collection;

public interface BookService {
    Book createOrUpdate(Book book);

    Collection<Book> list();
}