package Methods;

import DB.Facade;
import Entity.Book;
import MyUtil.UserInput;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Books {
    List<Book> bookList = Facade.fetchBooks();

    public void showBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    public void deleteBook() {
        Facade.deleteBook(UserInput.getInt("Enter book ID"));
    }

    public void updateBooks() {
        Facade.updateBooks();
    }

    public void addBook() throws SQLException {
        Book book = new Book(UserInput.getString("Insert title"), UserInput.getString("Insert author"), UserInput.getInt("Insert release year"), UserInput.getInt("Insert version"));
        System.out.println("You have now added the book \n" + Facade.addBook(book).toString());
    }

}
