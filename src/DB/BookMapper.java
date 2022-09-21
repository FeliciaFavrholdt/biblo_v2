package DB;

import Entity.Book;

import java.sql.*;

public class BookMapper {

    public static Book addBook(Book book) {

        String sql = "INSERT INTO Bog (Forfatter , Title ) VALUES (?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            try {
                ps.setString(1, book.getAuthor());
                ps.setString(2, book.getTitle());
                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();
                resultSet.next();

                int bookId = resultSet.getInt(1);
                book.setBookId(bookId);

                return book;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return book;
        }
    }
}
