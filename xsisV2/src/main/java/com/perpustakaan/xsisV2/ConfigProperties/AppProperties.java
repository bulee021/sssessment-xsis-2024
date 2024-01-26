package com.perpustakaan.xsisV2.ConfigProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Configuration
@ConfigurationProperties("app")
public class AppProperties {

    // QUERY CUSTOMER
    private String QUERY_ALL_CUSTOMER = "SELECT * FROM CUSTOMER";
    private String QUERY_CUSTOMER_ACTIVE = "select * from customer where isdelete = 'FALSE'";
    private String QUERY_INSERT_CUSTOMER = "INSERT INTO CUSTOMER (NAME, CUSTOMER_ID, CONTACT, ISDELETE) VALUES (?,?,?,?)";
    private String QUERY_DELETE_CUSTOMER = "UPDATE customer SET isdelete = 'TRUE' WHERE customer_id = ?";

    // QUERY BOOK
    private String QUERY_BOOK_BY_ISBN = "select id, title, author, publisher, release, " +
            "isbn, category, description, stock, created_at from book where isbn = ?";
    private String QUERY_INSERT_BOOK = "INSERT INTO book\n" +
            "(title, author, publisher, release, isbn, category, description, stock)\n" +
            "VALUES( ?, ?, ?, ?, ?, ?, ?, ?);";
    private String QUERY_DELETE_BOOK = "DELETE FROM book WHERE isbn = ?";
    private String QUERY_UPDATE_STOCK_USING_ISBN = "UPDATE book SET stock = ? WHERE isbn = ?";

    // BORROWING
    private String INSERT_BORROWING = "insert into borrowing(customer_id, isbn, borrowing_date, " +
            "returning_date, borrowing_code)\n" +
            "values(?, ?, ?, ?, ?)";
    private String GET_RESULT_BORROWING_BY_BORROWING_CODE = "select * from borrowing where borrowing_code = ?";

    // RETURNING BOOK
    private String INSERT_RETURNING_BOOK = "insert into return_book(return_date, penalty, customer_id, return_book_code)" +
            "values(?, ?, ?, ?)";
}
