package com.perpustakaan.xsisV2.Model;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowing {

    private int id;
    private String customer_id;
    private String isbn;
    private Date borrowing_date;
    private Date returning_date;
    private String borrowing_code;

}
