package Methods;

import DB.Facade;
import Entity.Book;
import Entity.BookRental;
import MyUtil.UserInput;

import java.sql.SQLException;
import java.util.List;

public class BookRentals {

    public void addBookRental() throws SQLException {
        BookRental bookRental = new BookRental(
                UserInput.getInt("Insert CostumerID"),
                UserInput.getInt("Insert BookID"),
                UserInput.getString("Insert date!")
        );
        System.out.println("Rental data: " + Facade.addBookRental(bookRental));
    }

    public void showBookRentals(List<BookRental> bookRentalList) {
        for (BookRental br : bookRentalList) {
            System.out.println(br.toString());
        }
    }
}
