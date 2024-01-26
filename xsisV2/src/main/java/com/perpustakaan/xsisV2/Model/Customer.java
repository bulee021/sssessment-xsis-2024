package com.perpustakaan.xsisV2.Model;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    private int id;
    private String name;
    private String customer_id;
    private String contact;
    private Date created_at;
    private String isDelete;

}
