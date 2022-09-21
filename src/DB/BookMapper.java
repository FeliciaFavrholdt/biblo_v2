package DB;

import Entity.Book;

import java.sql.*;

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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return book;
        }
    }
}
