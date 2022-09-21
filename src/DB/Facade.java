package DB;

import Entity.Book;

public class Facade {

    public static Book addBook(Book book) {
        return BookMapper.addBook(book);
    }


}
