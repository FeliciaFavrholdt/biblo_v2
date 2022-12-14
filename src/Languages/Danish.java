package Languages;

import DB.Facade;
import Entity.Book;
import Entity.BookRental;
import Entity.Customer;
import Methods.BookRentals;
import Methods.Books;
import Methods.Customers;
import MyUtil.UserInput;

import java.sql.SQLException;
import java.util.List;

public class Danish implements LanguageController {

    private static final String bullet = "\u2022";
    private List<Book> bookList = Facade.fetchBooks();
    private List<Customer>customerList = Facade.fetchCustomers();

    private List<BookRental>bookRentalList = Facade.fetchBookRentals();
    private static final Books books = new Books();
    private static final Customers c = new Customers();
    private static final BookRentals bookRentals = new BookRentals();


    @Override
    public void allMenus() {
        int input;
        String s = "\nHovedMenu - Bibliotek" +
                "\nVenligst vælg en Menu ud fra de nedenstående eksempler:" +
                "\n" + bullet + " 1 = Kunder" +
                "\n" + bullet + " 2 = Bøger" +
                "\n" + bullet + " 3 = Bog Udlån\n";

        try {
            input = UserInput.getInt(s);
            switch (input) {
                case 1 -> customerMenu();
                case 2 -> booksMenu();
                case 3 -> bookRentalMenu();
                default -> System.out.println("Fejl i input -- Venligt prøv igen..");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }

    @Override
    public void customerMenu() {
        int input;
        String s = "\nKunde Menu: " +
                "\n" + bullet + " 1 = Tilføj Kunde" +
                "\n" + bullet + " 2 = Opdater Kundeinformation" +
                "\n" + bullet + " 3 = Slet Kunde" +
                "\n" + bullet + " 4 = Vis alt registreret KundeData\n";

        try {
            input = UserInput.getInt(s);
            switch (input) {
                case 1 -> c.addCustomer();
                case 2 -> c.updateCustomer(customerList);
                case 3 -> c.deleteCustomer();
                case 4 -> c.showCustomers(customerList);
                default -> System.out.println("Fejl i input -- Venligst prøv igen..");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }

    @Override
    public void booksMenu() {
        int input;
        String s = "\nBog Menu: " +
                "\n" + bullet + " 1 = Tilføj ny Bog" +
                "\n" + bullet + " 2 = Opdater Bog Information" +     //The Danish menu shown to the customer
                "\n" + bullet + " 3 = Slet en Bog" +
                "\n" + bullet + " 4 = Vis alle bøger\n";

        try {
            input = UserInput.getInt(s);
            switch (input) {
                case 1 -> books.addBook();
                case 2 -> books.updateBooks(bookList);
                case 3 -> books.deleteBook();
                case 4 -> books.showBooks(bookList);
                default -> System.out.println("Fejl i input -- Venligst prøv igen..");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }

    @Override
    public void bookRentalMenu() {
        int input;
        String s = "\nBog Udlejning: " +
                "\n" + bullet + " 1 = Lej en Bog" +
                "\n" + bullet + " 2 = Vis alle Udlejet Bøger\n";

        input = UserInput.getInt(s);
        try {
            switch (input) {
                case 1 -> bookRentals.addBookRental();
                case 2 -> bookRentals.showBookRentals(bookRentalList);
                default -> System.out.println("Something went wrong.. Try again");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }
}
