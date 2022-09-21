package Entity;

public class BookRental {
    private int bookRentalID;
    private int customerID;
    private int booksID;
    private String date;

    // CONSTRUCTOR - from DB to object
    public BookRental(int bookRentalID, int customerID, int booksID, String date) {
        this.bookRentalID = bookRentalID;
        this.customerID = customerID;
        this.booksID = booksID;
        this.date = date;
    }

    // CONSTRUCTOR - from object to DB (first time)
    public BookRental(int customerID, int booksID, String date) {
        this.customerID = customerID;
        this.booksID = booksID;
        this.date = date;
    }

    public int getBookRentalID() {
        return bookRentalID;
    }

    public void setBookRentalID(int bookRentalID) {
        this.bookRentalID = bookRentalID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getBooksID() {
        return booksID;
    }

    public void setBooksID(int booksID) {
        this.booksID = booksID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BookRental {" +
                "bookRentalID = " + bookRentalID +
                ", customerID = " + customerID +
                ", booksID = " + booksID +
                ", date = '" + date + '\'' +
                '}';
    }
}
