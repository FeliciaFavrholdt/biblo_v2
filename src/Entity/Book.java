package Entity;

public class Book {

    private int bookID;
    private String title;
    private String author;
    private int releaseYear;
    private int version;

    // CONSTRUCTOR - from DB to object
    public Book(int bookID, String title, String author, int releaseYear, int version) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.version = version;
    }

    // CONSTRUCTOR - from object to DB (first time)
    public Book(String title, String author, int releaseYear, int version) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.version = version;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", version=" + version +
                '}';
    }
}
