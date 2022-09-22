package Methods;

import DB.DBViews;

import java.sql.SQLException;

public class Views {

    DBViews views = new DBViews();

    public void showAllViews() throws SQLException {
        views.RentedBooksView();
        views.rentedBooksInXX();
    }
}
