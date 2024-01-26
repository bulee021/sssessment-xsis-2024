package com.perpustakaan.xsisV2.Repository;

import com.perpustakaan.xsisV2.ConfigProperties.AppProperties;
import com.perpustakaan.xsisV2.Model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class CustomerRepository {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomerActive(){
        List<Customer> result = jdbcTemplate.query(
            appProperties.getQUERY_CUSTOMER_ACTIVE(), new BeanPropertyRowMapper<>(Customer.class)
        );
        return result;
    }

    public void insertCustomer(String name, String customer_id, String contact, String isDelete){
        jdbcTemplate.update(appProperties.getQUERY_INSERT_CUSTOMER(), name, customer_id, contact, isDelete);
    }

    public void deleteCustomer(String customer_id){
        jdbcTemplate.update(appProperties.getQUERY_DELETE_CUSTOMER(), customer_id);
    }
}
