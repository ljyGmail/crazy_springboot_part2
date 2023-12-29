package org.crazyit.app.dao;

import org.crazyit.app.domain.Author;
import org.crazyit.app.domain.Book;
import org.crazyit.app.domain.Wrote;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SyncAuthorDaoTest {

    @Autowired
    private SyncAuthorDao authorDao;

    @Test
    public void testSave() {
        Author author = new Author("老梁", "哈尔滨");
        // 创建Book对象，并建立Book与Author的关系
        Book book = new Book("老梁讲故事", 60);
        book.setAuthor(author);
        // 创建Wrote关系
        Wrote wrote1 = new Wrote("2015", book);
        author.getBooks().add(wrote1);

        Book book2 = new Book("老梁观世界", 70);
        book2.setAuthor(author);
        Wrote wrote2 = new Wrote("2016", book2);
        author.getBooks().add(wrote2);
        authorDao.save(author);
    }

    @ParameterizedTest
    @ValueSource(longs = {26L})
    public void testFindById(Long id) {
        authorDao.findById(id).ifPresent(author -> {
            System.out.println(author + "--->" + author.getBooks());
            author.getBooks().forEach(writtenBy -> System.out.println(writtenBy.getBook()));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"老梁", "老金"})
    public void testFindByName(String name) {
        System.out.println(authorDao.findByName(name));
    }
}
