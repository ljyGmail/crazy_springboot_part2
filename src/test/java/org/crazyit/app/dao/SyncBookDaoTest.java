package org.crazyit.app.dao;

import org.crazyit.app.domain.Author;
import org.crazyit.app.domain.Book;
import org.crazyit.app.domain.Wrote;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SyncBookDaoTest {
    @Autowired
    private SyncBookDao bookDao;

    @Autowired
    private SyncAuthorDao authorDao;

    @Test
    public void testSave() {
        Book book = new Book("老梁讲四大名著", 100);
        Author author = authorDao.findByName("老梁");
        author.getBooks().add(new Wrote("2020", book));
        book.setAuthor(author);
        bookDao.save(book);
    }

    @ParameterizedTest
    @ValueSource(longs = {29})
    public void testFindBYId(Long id) {
        bookDao.findById(id).ifPresent(book -> System.out.println(book + "-->" + book.getAuthor()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"老梁*"})
    public void testFindByTitleLike(String titlePattern) {
        bookDao.findByTitleLike(titlePattern)
                .forEach(book -> System.out.println(book + "-->" + book.getAuthor()));
    }

    @ParameterizedTest
    @ValueSource(strings = "老梁.*事")
    public void testFindByTitleMatches(String regex) {
        bookDao.findByTitleMatches(regex)
                .forEach(book -> System.out.println(book + "-->" + book.getAuthor()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"世界", "名著"})
    public void testFindByTitleContains(String subTitle) {
        System.out.println(subTitle);
        bookDao.findByTitleContaining(subTitle)
                .forEach(book -> System.out.println(book + "-->" + book.getAuthor()));
    }

    @ParameterizedTest
    @CsvSource({"50, 70", "90, 110"})
    public void testFindByPriceBetween(double start, double end) {
        bookDao.findByPriceBetween(start, end)
                .forEach(book -> System.out.println(book + "-->" + book.getAuthor()));
    }

    @ParameterizedTest
    @CsvSource({"老梁讲故事, 60"})
    public void testExampleQuery1(String title, int price) {
        // 创建样本对象(probe)
        var s = new Book(title, price);
        // 不使用ExampleMatcher，创建默认的Example
        bookDao.findAll(Example.of(s))
                .forEach(book -> System.out.println(book + "-->" + book.getAuthor()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"老梁观世界"})
    public void textExampleQuery2(String title) {
        // 创建matchingAll的ExampleMatcher
        ExampleMatcher matcher = ExampleMatcher.matching()
                // 忽略null属性，该方法可以省略
                // .withIgnoreNullValues()
                .withIgnorePaths("price"); // 忽略price属性
        // 创建样本对象(probe)
        var s = new Book(title, 1);
        bookDao.findAll(Example.of(s, matcher))
                .forEach(book -> System.out.println(book + "-->" + book.getAuthor()));
    }

    @ParameterizedTest
    @CsvSource({"60, 80", "90, 130"})
    public void testFindByQuery1(double start, double end) {
        bookDao.findByQuery1(start, end)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"疯狂.+", "老梁.*"})
    public void testFindByQuery2(String titlePattern) {
        bookDao.findByQuery2(titlePattern)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"老梁.*, 70", "疯狂Python.*, 110"})
    public void testCustomQuery1(String regex, int startPrice) {
        bookDao.customQuery1(regex, startPrice)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"110, 120", "120, 130"})
    public void testCustomQuery2(int startPrice, int endPrice) {
        bookDao.customQuery2(startPrice, endPrice)
                .forEach(book -> System.out.println(book + "-->" + book.getAuthor()));
    }
}
