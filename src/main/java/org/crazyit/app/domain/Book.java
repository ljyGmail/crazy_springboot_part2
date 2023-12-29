package org.crazyit.app.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node(labels = {"Book", "Item"}, primaryLabel = "Book")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int price;
    @Relationship(type = "WRITTEN_BY", direction = Relationship.Direction.OUTGOING)
    private Author author;

    public Book() {
    }

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Book newObject = new Book(this.title, this.price);
            newObject.id = id;
            return newObject;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
