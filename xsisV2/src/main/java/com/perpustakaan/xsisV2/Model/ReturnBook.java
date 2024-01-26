package com.perpustakaan.xsisV2.Model;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReturnBook {

    private int id;
    private Date return_date;
    private int penalty;
    private String customer_id;
    private String return_book_code;

}
