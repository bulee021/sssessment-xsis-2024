package com.perpustakaan.xsisV2.Repository;

import com.perpustakaan.xsisV2.ConfigProperties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ReturnBookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppProperties appProperties;

    public void insertReturnBook(Date return_date,
                                 int penalty,
                                 String customer_id,
                                 String return_book_code){
        jdbcTemplate.update(appProperties.getINSERT_RETURNING_BOOK(), return_date, penalty, customer_id, return_book_code);
    }
}
