package Methods;

import DB.Facade;
import Entity.Book;
import Entity.BookRental;
import MyUtil.UserInput;

import java.sql.SQLException;
import java.util.List;

public class BookRentals {

    public void addBookRental() throws SQLException {
        List list = Facade.fetchCustomers();
        for (Object o : list) {
            System.out.println(o);
        }
                int costumerID = UserInput.getInt("Insert CostumerID");
        list = Facade.fetchBooks();
        for (Object o : list) {
            System.out.println(o);
        }
                int bookId = UserInput.getInt("Insert BookID");
                String date = UserInput.getString("Insert date!");
        BookRental bookRental = new BookRental(costumerID,bookId,date);
        System.out.println("Rental data: " + Facade.addBookRental(bookRental));
    }

    public void showBookRentals(List<BookRental> bookRentalList) {
        for (BookRental br : bookRentalList) {
            System.out.println(br.toString());
        }
    }
}
