package Languages;

import DB.Facade;
import Entity.Book;
import Entity.Customer;
import Methods.BookRentals;
import Methods.Books;
import Methods.Customers;
import MyUtil.UserInput;
import java.sql.SQLException;
import java.util.List;

public class English implements LanguageController {

    private List<Book> bookList = Facade.fetchBooks();
    private List<Customer>customerList = Facade.fetchCustomers();
    private static final String bullet = "\u2022";
    private static final Books books = new Books();
    private static final Customers c = new Customers();
    private static final BookRentals bookRentals = new BookRentals();


    @Override
    public void allMenus() throws SQLException {
        int input;
        String s = "\nMain Menu - Library" +
                "\nWhich menu do you want to go to?" +
                "\n" + bullet + " 1 = Customers" +
                "\n" + bullet + " 2 = Books" +
                "\n" + bullet + " 3 = Book Rentals\n";

        input = UserInput.getInt(s);
        switch (input) {
            case 1 -> customerMenu();
            case 2 -> booksMenu();
            case 3 -> bookRentalMenu();
            default -> System.out.println("Something went wrong.. Try again");
        }
        allMenus();
    }

    @Override
    public void customerMenu() throws SQLException {
        int input;
        String s = "\nCustomer Menu: " +
                "\n" + bullet + " 1 = add a customer" +
                "\n" + bullet + " 2 = update a customer" +
                "\n" + bullet + " 3 = delete a customer" +
                "\n" + bullet + " 4 = show all customer data\n";


        input = UserInput.getInt(s);
        switch (input) {
            case 1 -> c.addCustomer();
            case 2 -> c.updateCustomer(customerList);
            case 3 -> c.deleteCustomer();
            case 4 -> c.showCustomers(customerList);
            default -> System.out.println("Something went wrong.. Try again");
        }
        allMenus();
    }

    @Override
    public void booksMenu() throws SQLException {
        int input;
        String s = "\nMethods.Books Menu: " +
                "\n" + bullet + " 1 = add new book" +
                "\n" + bullet + " 2 = update book data" +
                "\n" + bullet + " 3 = delete a book" +
                "\n" + bullet + " 4 = show all books\n";

        try {
            input = UserInput.getInt(s);
            switch (input) {
                case 1 -> books.addBook();
                case 2 -> books.updateBooks(bookList);
                case 3 -> books.deleteBook();
                case 4 -> books.showBooks(bookList);
                default -> System.out.println("Something went wrong.. Try again");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }

    public void bookRentalMenu() {
        int input;
        String s = "\nBook Rental Menu: " +
                "\n" + bullet + " 1 = Rent out a book" +
                "\n" + bullet + " 2 = Show all rented books\n";

        input = UserInput.getInt(s);
        try {
            switch (input) {
                case 1 -> System.out.println("bookRental");
                case 2 -> System.out.println("showBooksRentedView");
                case 3 -> System.out.println("returnBook");
                case 4 -> System.out.println("deleteBookRental");
                default -> System.out.println("Something went wrong.. Try again");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
