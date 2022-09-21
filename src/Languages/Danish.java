package Languages;

import DB.Facade;
import Entity.Book;
import Methods.Books;
import MyUtil.UserInput;

import java.util.List;

public class Danish implements LanguageController {

    private static final String bullet = "\u2022";
    private List<Book> bookList = Facade.fetchBooks();

    private static final Books books = new Books();
//    private static BookRentals bookRentals = new BookRentals();
//    private static Customers customers = new Customers();

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
                "\n" + bullet + " 4 = Vis alle registreret Kundenavne" +
                "\n" + bullet + " 5 = Vis alt registreret KundeData\n";

        try {
            input = UserInput.getInt(s);
            switch (input) {
                case 1 -> System.out.println("addCustomer");
                case 2 -> System.out.println("updateCustomer");
                case 3 -> System.out.println("deleteCustomer");
                case 4 -> System.out.println("showCustomerNames");
                case 5 -> System.out.println("showAllCustomerData");
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
        switch (input) {
            case 1 -> System.out.println("book rental");
            case 2 -> System.out.println("showBooksRentedView");
            case 3 -> System.out.println("returnBook");
            case 4 -> System.out.println("deleteBookRental");
            default -> System.out.println("Fejl i input -- Venligst prøv igen..");
        }
        allMenus();
    }
}
