package Languages;

import Entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface LanguageController {

    // This interface is used as a Language controller switching
    // between the different languages by implementing itself into
    // the different language classes.

    void allMenus() throws SQLException;
    void customerMenu() throws SQLException;

    void booksMenu() throws SQLException;

    void bookRentalMenu();
}
