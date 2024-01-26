package com.perpustakaan.xsisV2.Usecase;

import com.perpustakaan.xsisV2.Model.Book;
import com.perpustakaan.xsisV2.Model.Borrowing;
import com.perpustakaan.xsisV2.Model.Customer;
import com.perpustakaan.xsisV2.Repository.BookRepository;
import com.perpustakaan.xsisV2.Repository.BorrowingRepository;
import com.perpustakaan.xsisV2.Repository.CustomerRepository;
import com.perpustakaan.xsisV2.Repository.ReturnBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class LibraryUsecase {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private ReturnBookRepository returnBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private final String patternDate = "dd-MM-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternDate);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(patternDate);

    public void BorrowingBook(String customer_id, String isbn,
                              int borrowing_days, String borrowing_code) throws ParseException {

        // GET DATE NOW AND RETURNING DATE
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_WEEK, borrowing_days);


        // CONVERT DATE TO STRING -> STRING TO DATE
        String borrowFormat = simpleDateFormat.format(date);
        String returnFormat = simpleDateFormat.format(calendar.getTime());
        Date borrowDate = new SimpleDateFormat(patternDate).parse(borrowFormat);
        Date returnDate = new SimpleDateFormat(patternDate).parse(returnFormat);

        Book book = bookRepository.getBookByIsbn(isbn);
        if(book.getStock() != 0){
            borrowingRepository.insertBorrowing(customer_id, isbn, borrowDate,
                    returnDate, borrowing_code);
            bookRepository.updateBookStock(book.getStock() - 1, isbn);
        }else{
            System.out.println("Book " + book.getTitle() + " is not available!");
        }
    }

    public void returningBook(String borrowing_code, String return_date,
                              String customer_id, String return_book_code) throws ParseException {
        // GET DATA FROM DATABASE
        Borrowing borrowing = borrowingRepository.getResultByCode(borrowing_code);
        // CHECK IF BORROWING CODE EXIST
        if(borrowing != null){
            // PARSE DATE FROM DATABASE
            Date borrowingReturnDate = borrowing.getReturning_date();
            String getReturnDate = simpleDateFormat.format(borrowingReturnDate);
            LocalDate ldReturnDate = LocalDate.parse(getReturnDate, dateTimeFormatter);

            // PARSE DATE FROM INPUT
            LocalDate ldInputReturnDate = LocalDate.parse(return_date, dateTimeFormatter);
            Date dReturnDate = simpleDateFormat.parse(return_date);

            // CHECK IF RETURN DATE IS LESS THAN OR MORE THAN OR EQUAL
            if(ldInputReturnDate.isBefore(ldReturnDate) || ldInputReturnDate.isEqual(ldReturnDate)){
                returnBookRepository.insertReturnBook(dReturnDate, 0, customer_id, return_book_code);
                System.out.println("ANJAY MANTAP GAN, KEMBALI TEPAT WAKTU");
            }else if(ldInputReturnDate.isAfter(ldReturnDate)){
                // GET DAYS BETWEEN RETURN BOOK DATE DATABASE AND USER RETURN BOOK DATE
                long getDays = ChronoUnit.DAYS.between(ldReturnDate, ldInputReturnDate);
                int penalty = (int) getDays * 15000;
                returnBookRepository.insertReturnBook(dReturnDate, penalty, customer_id, return_book_code);
                System.out.println("LU KENA DENDA BABI!");
            }
        }else{
            System.out.println("LU MALING SU, GA ADA KODE NJIRR!!");
        }
    }

    public void addCustomer(String name, String contact){
        // GET SIZE FROM CUSTOMER
        List<Customer> customers = customerRepository.getCustomerActive();

        // GENERATE CUSTOMER ID
        Date year = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMyy");
        String customerId = dateFormat.format(year) + Integer.toString(customers.size() + 1);

        // INSERT INTO DATABASE
        customerRepository.insertCustomer(name, customerId, contact, "FALSE");
    }
}
