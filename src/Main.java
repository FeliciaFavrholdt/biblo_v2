import DB.DBViews;
import DB.Facade;
import Entity.Book;
import Languages.Danish;
import Languages.English;
import Languages.French;
import Languages.LanguageController;
import Methods.Views;
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
        //Views views = new Views();
        //views.showAllViews();
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
}