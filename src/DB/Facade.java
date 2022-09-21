package DB;

import Entity.Book;

import java.sql.SQLException;
import java.util.List;

public class Facade {

    public static Book addBook(Book book) throws SQLException {
        return BookMapper.addBook(book);
    }


    public static List<Book> fetchBooks() {
        return BookMapper.fetchBooks();
    }
}
