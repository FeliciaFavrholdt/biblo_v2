package DB;

import DB.ConnectionConfiguration;
import Entity.Book;
import Entity.BookRental;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookRentalMapper {

    protected static BookRental addBookRental(BookRental bookRental) throws SQLException {

        String sql = "INSERT INTO Bookrental (customersID, booksID, Date) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            try {
                ps.setInt(1, bookRental.getCustomerID());
                ps.setInt(2, bookRental.getBooksID());
                ps.setString(3, bookRental.getDate());
                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();
                resultSet.next();

                int bookRentalId = resultSet.getInt(1);
                bookRental.setBookRentalID(bookRentalId);
                //System.out.println(bookRental.toString());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return bookRental;
        }
    }

    protected static List<BookRental> fetchBookRentals() {

        List<BookRental> bookRentalList = new LinkedList<>();
        String sql = "select * from Bookrental";

        try (Connection con = ConnectionConfiguration.getConnection();

             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int bookRentalID = resultSet.getInt("BookrentalID");
                int customersID = resultSet.getInt("customersID");
                int bookID = resultSet.getInt("booksID");
                String date = resultSet.getString("Date");


                BookRental bookRental = new BookRental(bookRentalID, customersID, bookID, date);
                bookRentalList.add(bookRental);
            }
            ConnectionConfiguration.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookRentalList;
    }

    protected static String deleteBookRental(int bookRentalID) {
        String sql = "delete from Bookrental where BookrentalID = ?";

        try (Connection con = ConnectionConfiguration.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, bookRentalID);
            int res = ps.executeUpdate();
            if (res > 0) {
                return "Book rental with ID " + "\"" + bookRentalID + "\"" + " has now been deleted";
            }
            ConnectionConfiguration.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "A book rental with the id " + "\"" + bookRentalID + "\"" + " was not found";
    }


}
