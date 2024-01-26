package com.perpustakaan.xsisV2.Model;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private Date release;
    private String isbn;
    private String category;
    private String description;
    private int stock;
    private Timestamp created_at;

    public Book(String title, String author, String publisher, Date release, String isbn, String category, String description, int stock) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.release = release;
        this.isbn = isbn;
        this.category = category;
        this.description = description;
        this.stock = stock;
    }
}
