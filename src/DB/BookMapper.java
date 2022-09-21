package DB;

import Entity.Book;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookMapper {

    public static Book addBook(Book book) throws SQLException {

        String sql = "INSERT INTO Books (Author, Title, ReleaseYear, Version) VALUES (?, ?, ?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            try {
                ps.setString(1, book.getAuthor());
                ps.setString(2, book.getTitle());
                ps.setInt(3, book.getReleaseYear());
                ps.setInt(4, book.getVersion());
                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();
                resultSet.next();

                int bookId = resultSet.getInt(1);
                book.setBookID(bookId);
                //System.out.println(book.toString());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return book;
        }
    }

    public static List<Book> fetchBooks() {

        List<Book> bookList = new LinkedList<>();
        String sql = "select * from Books";

        try (Connection con = ConnectionConfiguration.getConnection();

             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int bookID = resultSet.getInt("BookID");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");
                int releaseYear = resultSet.getInt("ReleaseYear");
                int version = resultSet.getInt("Version");


                Book book = new Book(bookID, title, author, releaseYear, version);
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
}
