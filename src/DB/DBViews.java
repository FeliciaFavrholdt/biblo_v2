package DB;

import java.sql.*;

public class DBViews {

    //create view RentedBooksView as
    //SELECT customersID,CustomerName,booksID,Title FROM bookrental
    //inner join customers c on bookrental.customersID = c.CustomerID
    //inner join books b on bookrental.booksID = b.BookID;
    //put methods here for db views
    public void views() {

    }

    public void RentedBooksView() throws SQLException {
        String sql = "create view RentedBooksView as " +
                "SELECT customersID,CustomerName,booksID,Title " +
                "FROM bookrental " +
                "inner join customers c on bookrental.customersID = c.CustomerID " +
                "inner join books b on bookrental.booksID = b.BookID";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
