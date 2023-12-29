package org.crazyit.app.domain;

import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Wrote {
    @TargetNode
    private Book book;
    private String year;

    public Wrote() {
    }

    public Wrote(String year, Book book) {
        this.book = book;
        this.year = year;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Wrote{" +
                "year='" + year + '\'' +
                '}';
    }
}
