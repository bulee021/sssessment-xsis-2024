package com.perpustakaan.xsisV2.Controller;

import com.perpustakaan.xsisV2.ConfigProperties.AppProperties;
import com.perpustakaan.xsisV2.Model.Book;
import com.perpustakaan.xsisV2.Model.Customer;
import com.perpustakaan.xsisV2.Repository.BookRepository;
import com.perpustakaan.xsisV2.Repository.CustomerRepository;
import com.perpustakaan.xsisV2.Usecase.LibraryUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class PerpustakaanController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryUsecase libraryUsecase;

    @Autowired
    private AppProperties appProperties;

    @RequestMapping(value = "/customer/get-customer-active", method = RequestMethod.GET)
    public List<Customer> getActiveCustomer(){
        return customerRepository.getCustomerActive();
    }

    @RequestMapping(value = "/customer/insert-customer", method = RequestMethod.POST)
    public String insertMhs(@RequestHeader(name = "name") String name,
                            @RequestHeader(name = "contact") String contact){

        libraryUsecase.addCustomer(name, contact);
        return "Customer save successfully!";
    }

    @RequestMapping(value = "/customer/delete-customer", method = RequestMethod.DELETE)
    public String deleteCustomer(@RequestParam(name = "customer-id") String customer_id){
        customerRepository.deleteCustomer(customer_id);
        return "Customer deleted!";
    }

    @RequestMapping(value = "/book/get-book-isbn", method = RequestMethod.GET)
    public Book getBookByIsbn(@RequestParam(name = "isbn") String isbn){
        return bookRepository.getBookByIsbn(isbn);
    }

    @RequestMapping(value = "/book/insert-book", method = RequestMethod.POST)
    public String insertBook(@RequestHeader(name = "title") String title,
                          @RequestHeader(name = "author") String author,
                          @RequestHeader(name = "publisher") String publisher,
                          @RequestHeader(name = "release") String release,
                          @RequestHeader(name = "isbn") String isbn,
                          @RequestHeader(name = "category") String category,
                          @RequestBody String description,
                          @RequestHeader(name = "stock") int stock) throws ParseException {
        String datePattern = "dd-mm-yyyy";
        Date dateRelease = new SimpleDateFormat(datePattern).parse(release);
        bookRepository.insertBook(title, author, publisher, dateRelease, isbn, category, description, stock);
        return "Insert Book Successfully!";
    }

    @RequestMapping(value = "/book/delete-book", method = RequestMethod.DELETE)
    public String deleteBook(@RequestParam(name = "isbn") String isbn){
        bookRepository.deleteBook(isbn);
        return "Delete Book Successfully!";
    }

    @RequestMapping(value = "/book/update-book-stock", method = RequestMethod.PUT)
    public String updateBookStock(@RequestParam(name = "isbn") String isbn,
                                @RequestHeader(name = "stock") int stock){
        bookRepository.updateBookStock(stock, isbn);
        return "Update stock book with isbn " + isbn + " is successfully!";
    }
}
