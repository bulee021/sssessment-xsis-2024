package com.perpustakaan.xsisV2.Repository;

import com.perpustakaan.xsisV2.ConfigProperties.AppProperties;
import com.perpustakaan.xsisV2.Model.Book;
import com.perpustakaan.xsisV2.Model.Borrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class BorrowingRepository {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertBorrowing(String customer_id, String isbn,
                                Date borrowing_date, Date returning_date,
                                String borrowing_code){
        jdbcTemplate.update(appProperties.getINSERT_BORROWING(), customer_id, isbn,
                borrowing_date, returning_date, borrowing_code);
    }

    public Borrowing getResultByCode(String borrowing_code){
        return jdbcTemplate.queryForObject(
                appProperties.getGET_RESULT_BORROWING_BY_BORROWING_CODE(),
                new Object[]{borrowing_code},
                (rs, rowNum) ->
                        new Borrowing(
                                rs.getInt("id"),
                                rs.getString("customer_id"),
                                rs.getString("isbn"),
                                rs.getDate("borrowing_date"),
                                rs.getDate("returning_date"),
                                rs.getString("borrowing_code")
                        )
        );
    }
}
