package com.perpustakaan.xsisV2.Repository;

import com.perpustakaan.xsisV2.ConfigProperties.AppProperties;
import com.perpustakaan.xsisV2.Model.Book;
import com.perpustakaan.xsisV2.Model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class BookRepository {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Book getBookByIsbn(String isbn){
        return jdbcTemplate.queryForObject(
                appProperties.getQUERY_BOOK_BY_ISBN(),
                new Object[]{isbn},
                (rs, rowNum) ->
                        new Book(
                                rs.getString("title"),
                                rs.getString("author"),
                                rs.getString("publisher"),
                                rs.getDate("release"),
                                rs.getString("isbn"),
                                rs.getString("category"),
                                rs.getString("description"),
                                rs.getInt("stock")
                        )
        );
    }

    public void insertBook(String title, String author, String publisher,
                           Date release, String isbn, String category,
                           String description, int stock){
        jdbcTemplate.update(appProperties.getQUERY_INSERT_BOOK(), title, author, publisher,
                release, isbn, category, description, stock);
    }

    public void deleteBook(String isbn){
        jdbcTemplate.update(appProperties.getQUERY_DELETE_BOOK(), isbn);
    }

    public void updateBookStock(int stock, String isbn){
        jdbcTemplate.update(appProperties.getQUERY_UPDATE_STOCK_USING_ISBN(), stock, isbn);
    }
}
