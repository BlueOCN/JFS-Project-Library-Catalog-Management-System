import java.util.Objects;
import java.util.UUID;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    Book() {
        this.bookId = UUID.randomUUID().toString();
        this.title = "NA";
        this.author = "NA";
        this.genre = "NA";
        this.availabilityStatus = "NA";
    }

    Book(String title, String author, String genre, String availabilityStatus) {
        this.bookId = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(bookId, book.bookId) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre) && Objects.equals(availabilityStatus, book.availabilityStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, genre, availabilityStatus);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                '}';
    }

}
