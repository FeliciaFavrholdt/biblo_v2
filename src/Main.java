import DB.Facade;
import Entity.Book;
import MyUtil.UserInput;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Book book = new Book("title", "author", 2022, 10);
        //Facade.addBook(book);

        while (true) {
            switch (UserInput.getString("Choose one // Add Book")) {
                case "Add Book":
                    Book book = new Book(UserInput.getString("Insert title"),
                            UserInput.getString("Insert author"),
                            UserInput.getInt("Insert release year"),
                            UserInput.getInt("Insert version"));
                    System.out.println("You have now added the book" + Facade.addBook(book).toString());
            }
        }
    }
}