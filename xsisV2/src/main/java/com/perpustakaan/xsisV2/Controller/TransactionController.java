package com.perpustakaan.xsisV2.Controller;

import com.perpustakaan.xsisV2.Model.Borrowing;
import com.perpustakaan.xsisV2.Repository.BorrowingRepository;
import com.perpustakaan.xsisV2.Usecase.LibraryUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("transaction")
@Slf4j
public class TransactionController {

    @Autowired
    private LibraryUsecase libraryUsecase;

    @Autowired
    private BorrowingRepository borrowingRepository;

    @PostMapping("/borrowing-book")
    public void borrowingBook(@RequestHeader(name = "customer-id") String customer_id,
                              @RequestHeader(name = "isbn") String isbn,
                              @RequestHeader(name = "borrowing-days") int borrowing_days,
                              @RequestHeader(name = "borrowing-code") String borrowing_code) throws Exception {
        libraryUsecase.BorrowingBook(customer_id, isbn, borrowing_days, borrowing_code);
    }

    @PostMapping("/returning-book")
    public void returningBook(@RequestHeader(name = "return-date") String return_date,
                              @RequestHeader(name = "customer-id") String customer_id,
                              @RequestHeader(name = "return-book-code") String return_book_code,
                              @RequestHeader(name = "borrowing-code") String borrowing_code) throws Exception {
        libraryUsecase.returningBook(borrowing_code, return_date, customer_id, return_book_code);
    }

    @GetMapping("/result-by-code")
    public Borrowing getResultByCode(@RequestParam(name = "borrowing-code") String borrowing_code){
        return borrowingRepository.getResultByCode(borrowing_code);
    }
}
