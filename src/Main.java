import DB.Facade;
import Entity.Book;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Book book = new Book("title", "author", 2022, 10);
        try {
            Facade.addBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}