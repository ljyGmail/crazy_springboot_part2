package org.crazyit.app.dao;

import org.crazyit.app.domain.Author;
import org.crazyit.app.domain.Book;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Values;
import org.neo4j.driver.reactive.RxSession;
import org.neo4j.driver.types.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.ReactiveNeo4jTemplate;
import reactor.core.publisher.Flux;

import java.util.Map;

public class BookCustomDaoImpl implements BookCustomDao {
    @Autowired
    private ReactiveNeo4jTemplate neo4jTemplate;

    @Autowired
    private Driver driver;

    @Override
    public Flux<Book> customQuery1(String regex, int startPrice) {
        // 调用ReactiveNeo4jTemplate的findAll()方法执行CQL查询
        return neo4jTemplate.findAll("match (b :Book) where " +
                        "b.title =~ $0 and b.price >= $1 return b",
                Map.of("0", regex, "1", startPrice), Book.class);
    }

    @Override
    public Flux<Book> customQuery2(int startPrice, int endPrice) {
        // 获取RxSession
        RxSession rxSession = driver.rxSession();
        // 调用RxSession执行查询
        return Flux.from(
                        // 调用RxSession执行查询
                        rxSession.run("MATCH (b :Book)-[r]->(a) " +
                                                "WHERE b.price >= $startPrice and b.price <= $endPrice RETURN b, a",
                                        Values.parameters("startPrice", startPrice, "endPrice", endPrice))
                                // 调用records()方法返回Publisher<Record>
                                .records())
                // 将Flux<Record>映射成Flux<Book>
                .map(record -> {
                    Node node = record.get("b").asNode();
                    String title = node.get("title").asString();
                    int price = node.get("price").asInt();
                    long id = node.id();
                    Book book = new Book(title, price);
                    book.setId(id);
                    Node authorNode = record.get("a").asNode();
                    String name = authorNode.get("name").asString();
                    String addr = authorNode.get("author_addr").asString();
                    long authorId = authorNode.id();
                    Author author = new Author(name, addr);
                    author.setId(authorId);
                    book.setAuthor(author);
                    return book;
                });
    }
}
