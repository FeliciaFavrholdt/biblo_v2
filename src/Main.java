import DB.Facade;
import Entity.Book;
import Languages.Danish;
import Languages.English;
import Languages.French;
import Languages.LanguageController;
import MyUtil.UserInput;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static String bullet = "\u2022";
    private static LanguageController languageController;

    public static void main(String[] args) throws SQLException {

        mainMenu("");
        languageController.allMenus();
    }

    // Main menu - choose a language for the program DK, ENG, FR
    public static void mainMenu(String ErrorMessage) {
        int input;
        System.out.println(ErrorMessage);
        String s = "\nAnnouncement - Welcome to the Public Library" +
                "\nPlease choose a language! // Veuillez choisir une langue! // Vælg sprog! " +
                "\n" + bullet + " 1 = English // Anglais // Engelsk" +
                "\n" + bullet + " 2 = French // Francais // Fransk" +
                "\n" + bullet + " 3 = Danish // Danoise // Dansk\n";

        input = UserInput.getInt(s);
        switch (input) {
            case 1 -> languageController = new English();
            case 2 -> languageController = new French();
            case 3 -> languageController = new Danish();
            default -> mainMenu("\n Error -- Please choose from the options available.");
        }
    }

    public static void bookMenu() throws SQLException {
        List<Book> bookList = new LinkedList<>();

        while (true) {
            switch (UserInput.getString("Choose one // Add Book // Fetch Books // Delete Book")) {
                case "Add Book":
                    Book book = new Book(UserInput.getString("Insert title"), UserInput.getString("Insert author"), UserInput.getInt("Insert release year"), UserInput.getInt("Insert version"));
                    System.out.println("You have now added the book" + Facade.addBook(book).toString());
                    break;

                case "Fetch Books":
                    bookList = Facade.fetchBooks();
                    printBooks(bookList);
                    break;
                case "Delete Book":
                    Facade.deleteBook(UserInput.getInt("Enter book ID"));
            }
        }
    }

    public static void printBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }
}