package DB;

import Entity.Book;
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

    public static String updateBooks(Book book, int bookID) throws SQLException {
        return BookMapper.updateBooks(book);
    }

    //CUSTOMERS
    public static Customer addCustomer(Customer c) throws SQLException {
        return CustomerMapper.addCustomer(c);
    }

    public static List<Customer> fetchCustomers() {
        return CustomerMapper.fetchCustomers();
    }

    public static String deleteCustomer(int customerID) {
        return CustomerMapper.deleteCustomer(customerID);
    }

    public static String updateCustomers(Customer c, int customerID) throws SQLException {
        return CustomerMapper.updateCustomer(c);
    }


    //BOOK RENTALS
}
