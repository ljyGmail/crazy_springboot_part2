package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testSaveWithId() {
        var book = new Book("疯狂Kotlin", "系统易懂的Kotlin图书，覆盖数据分析、爬虫等热门内容", 139.0);
        // 显式设置id，通常不建议设置
        book.setId("4");
        bookDao.save(book).block(); // 阻塞执行，保证反应式方法执行完成
    }

    @Test
    public void testUpdate() {
        // 更新id为2的Book对象
        bookDao.findById("2")
                .blockOptional()
                .ifPresent(book -> {
                    book.setName("疯狂Python讲义");
                    bookDao.save(book).block();
                });
    }

    @Test
    public void testDelete() {
        // 删除id为2的Book对象
        bookDao.deleteById("2").block();
    }

    @ParameterizedTest
    @ValueSource(strings = {"疯狂"})
    public void testFindByNameLike(String namePattern) {
        bookDao.findByNameLike(namePattern)
                // 调用toIterable()方法以后以阻塞式方式完成查询
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"疯狂\\w+"})
    public void testFindByNameRegex(String regex) {
        bookDao.findByNameRegex(regex)
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java"})
    public void testFindByDescriptionContains(String subDesc) {
        bookDao.findByDescriptionContains(subDesc)
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"110, 140", "100, 110"})
    public void testFindByPriceBetween(double start, double end) {
        bookDao.findByPriceBetween(start, end)
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"疯狂Java, 系统易懂的Java图书，覆盖数据分析、爬虫等热门内容"})
    public void testExampleQuery1(String name, String description) {
        // 创建样本对象(probe)
        var s = new Book(name, description, 120.0);
        // 不使用ExampleMatcher，创建默认的Example
        bookDao.findAll(Example.of(s))
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"疯狂Kotlin"})
    public void testExampleQuery2(String name) {
        // 创建matchingAll的ExampleMatcher
        ExampleMatcher matcher = ExampleMatcher.matching()
                // 忽略null属性，该方法可以省略
                //.withIgnoreNullValues()
                .withIgnorePaths("price");// 忽略price属性
        // 创建样本对象(probe)
        var s = new Book(name, null, 1.0);
        bookDao.findAll(Example.of(s, matcher))
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"110, 120", "120, 130"})
    public void testFindByQuery1(double start, double end) {
        bookDao.findByQuery1(start, end)
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"疯狂\\w+", "疯狂Python\\w+"})
    public void testFindByQuery2(String namePattern) {
        bookDao.findByQuery2(namePattern)
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"疯狂\\w+, 120", "疯狂Python\\w*, 100"})
    public void testCustomQuery1(String regex, double startPrice) {
        bookDao.customQuery1(regex, startPrice)
                .toIterable().forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"110, 120", "120, 130"})
    public void testCustomQuery2(double startPrice, double endPrice) {
        bookDao.customQuery2(startPrice, endPrice)
                .toIterable().forEach(System.out::println);
    }
}
