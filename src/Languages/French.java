package Languages;

import DB.Facade;
import Entity.Book;
import Entity.Customer;
import Methods.BookRentals;
import Methods.Books;
import Methods.Customers;
import MyUtil.UserInput;

import java.util.List;

public class French implements LanguageController {
    private List<Book> bookList = Facade.fetchBooks();
    private List<Customer>customerList = Facade.fetchCustomers();


    private static final String bullet = "\u2022";
    private static final Books books = new Books();
    private static final Customers c = new Customers();
    private static final BookRentals bookRentals = new BookRentals();


    @Override
    public void allMenus() {
        int input;
        String s = "\nBibliothèque du menu principal" +
                "\nDans quel menu voulez-vous aller ?" +
                "\n" + bullet + " 1 = Clients" +
                "\n" + bullet + " 2 = Livres" +
                "\n" + bullet + " 3 = Louer un Livres\n";

        try {
            input = UserInput.getInt(s);
            switch (input) {
                case 1 -> customerMenu();
                case 2 -> booksMenu();
                case 3 -> bookRentalMenu();
                default -> System.out.println("Excuse-moi il'sappelle une croissant oui oui");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }

    @Override
    public void customerMenu() {
        int input;
        String s = "\nMenu pour un client: " +
                "\n" + bullet + " 1 = Ajouter un client" +
                "\n" + bullet + " 2 = J'aime manger des saucisses au petit déjeuner" +      //The French menu shown to the customer
                "\n" + bullet + " 3 = Éloigne-toi de ma vue" +
                "\n" + bullet + " 4 = Montrez-moi le contenu de votre peuple de gressins\n";


        try {
            input = UserInput.getInt(s);
            switch (input) {
                case 1 -> c.addCustomer();
                case 2 -> c.updateCustomer(customerList);
                case 3 -> c.deleteCustomer();
                case 4 -> c.showCustomers(customerList);
                default -> System.out.println("Tu as merdé, espèce d'œuf. réessayer");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }

    @Override
    public void booksMenu() {
        int input;
        String s = "\nCarte des livres: " +
                "\n" + bullet + " 1 = ajouter un nouveau démon à votre armée" +
                "\n" + bullet + " 2 = Mettez à jour le contenu de votre palais mental" +
                "\n" + bullet + " 3 = J'apprécie le jus de haricots noirs rôtis le matin" +
                "\n" + bullet + " 4 = Tout montrer!\n";

        try {
            input = UserInput.getInt(s);
            switch (input) {
                case 1 -> books.addBook();
                case 2 -> books.updateBooks(bookList);
                case 3 -> books.deleteBook();
                case 4 -> books.showBooks(bookList);
                default -> System.out.println("Réessayez .. espèce de crétin");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }

    @Override
    public void bookRentalMenu() {
        int input;
        String s = "\nRéserver le menu de la location: " +
                "\n" + bullet + " 1 = Louer une vache au pâturage" +
                "\n" + bullet + " 2 = Afficher toutes les vaches\n";


        input = UserInput.getInt(s);
        try {
            switch (input) {
                case 1 -> System.out.println("bookRental");
                case 2 -> System.out.println("showBooksRentedView");
                default -> System.out.println("Réessaye mon dieu");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        allMenus();
    }
}