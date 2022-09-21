package DB;

import Entity.Book;
import Entity.BookRental;
import Entity.Customer;

import java.sql.SQLException;
import java.util.List;

public class Facade {

    //BOOKS
    public static Book addBook(Book book) throws SQLException {
        return BookMapper.addBook(book);
    }

    public static List<Book> fetchBooks() {
        return BookMapper.fetchBooks();
    }

    public static String deleteBook(int bookID) {
        return BookMapper.deleteBook(bookID);
    }

    //CUSTOMERS
    public static Customer addCustomer(Customer customer) throws SQLException {
        return CustomerMapper.addCustomer(customer);
    }

    public static List<Customer> fetchCustomers() {
        return CustomerMapper.fetchCustomers();
    }

    public static String deleteCustomer(int CustomerID) {
        return CustomerMapper.deleteCustomer(customerID);
    }

    //BOOK RENTALS
    public static BookRental addBookRental(BookRental bookRental) throws SQLException {
        return BookRentalMapper.addBookRental(bookRental);
    }

    public static List<BookRental> fetchBookRentals() {
        return BookRentalMapper.fetchBookRentals();
    }

    public static String deleteBookRental(int bookRentalID) {
        return BookRentalMapper.deleteBookRental(bookRentalID);
    }
}
