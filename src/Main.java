import DB.Facade;
import Entity.Book;
import MyUtil.UserInput;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Book book = new Book("title", "author", 2022, 10);
        //Facade.addBook(book);

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