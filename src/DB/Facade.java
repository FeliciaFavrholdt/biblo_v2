package DB;

import Entity.Book;

import java.sql.SQLException;

public class Facade {

    public static Book addBook(Book book) throws SQLException {
        return BookMapper.addBook(book);
    }


}
