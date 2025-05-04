import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Catalog {

    private ArrayList<Book> booksCatalog;
    private HashMap<String, Book> booksMap;
    private HashSet<String> availabilityStatusTypes;

    public Catalog() {}
    public Catalog(ArrayList<Book> booksCatalog) {}

    public void addBook(Book book) {}
    public void removeBook(Book book) {}
    public Book getBookByTitle(String title) { return null; }
    public void viewBooksDetails(Book book) {}

    public void addAvailabilityStatus(String availabilityStatus) {}
    public void viewAvailabilityStatus(Book book) {}
}
