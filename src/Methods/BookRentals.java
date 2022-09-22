package Methods;

import DB.Facade;
import Entity.Book;
import Entity.BookRental;
import MyUtil.UserInput;

import java.util.List;

public class BookRentals {

    public void addBookRental() {
    }

    public void showBookRentals(List<BookRental> bookRentalList) {
        for (BookRental br : bookRentalList) {
            System.out.println(br.toString());
        }
    }
}
