import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Catalog {

    private ArrayList<Book> booksCatalog;
    private HashMap<String, Book> booksCatalogByTitle;
    private HashSet<String> availabilityStatusTypes;

    public Catalog() {
        this.booksCatalog = new ArrayList<>();
        this.booksCatalogByTitle = new HashMap<>();
        this.availabilityStatusTypes = new HashSet<>();

        // Add default availability status types for books
        availabilityStatusTypes.add("Available");
        availabilityStatusTypes.add("Checked Out");
        availabilityStatusTypes.add("Reserved");
        availabilityStatusTypes.add("Lost");
        availabilityStatusTypes.add("In Repair");
    }
    public Catalog(ArrayList<Book> booksCatalog) {
        this.booksCatalog = new ArrayList<>();
        this.booksCatalogByTitle = new HashMap<>();
        this.availabilityStatusTypes = new HashSet<>();

        // Add default availability status types for books
        availabilityStatusTypes.add("Available");
        availabilityStatusTypes.add("Checked Out");
        availabilityStatusTypes.add("Reserved");
        availabilityStatusTypes.add("Lost");
        availabilityStatusTypes.add("In Repair");

        // Update books Catalog
        this.booksCatalog = booksCatalog;
        System.out.println(this.booksCatalog);

        // Update books Catalog by Title
        for (Book book : booksCatalog) {
            booksCatalogByTitle.put(book.getTitle(), book);
        }

        System.out.println(booksCatalogByTitle);
    }

    public static void validateTitle(String title) {
        // Validate title
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        } else if (!title.matches("[a-zA-Z0-9\\s,.!?'-]+")) {
            throw new IllegalArgumentException("Title contains invalid characters");
        } else {
            System.out.println("\t Valid title: " + title);
        }
    }

    public static void validateAuthor(String author) {
        // Validate author name
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be empty.");
        } else if (!author.matches("[a-zA-Z\\s,.!?'-]+")) {
            throw new IllegalArgumentException("Author name contains invalid characters");
        } else {
            System.out.println("\tValid author name: " + author);
        }
    }

    public static void validateGenre(String genre) {
        // Validate genre
        if (genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty.");
        } else if (!genre.matches("[a-zA-Z\\s,-]+")) {
            throw new IllegalArgumentException("Genre contains invalid characters.");
        } else {
            System.out.println("\tValid genre: " + genre);
        }
    }

    public static void validateAvailabilityStatus(String availabilityStatus) {
        // Validate availability status
        if (!availabilityStatus.matches("(?i)Available|Checked Out|Reserved|Lost|In Repair")) {
            throw new IllegalArgumentException("Invalid availability status. Please enter one of the following: Available, Checked Out, Reserved, Lost, In Repair");
        } else {
            System.out.println("\tValid availability status: " + availabilityStatus);
        }
    }

    public void addBook(Book book) {

        // Validate book
        if (book.getTitle().isBlank()) { throw new IllegalArgumentException("Book title is blank"); }
        if (book.getAuthor().isBlank()) { throw new IllegalArgumentException("Book author is blank"); }
        if (book.getGenre().isBlank()) { throw new IllegalArgumentException("Book genre is blank"); }
        if (book.getAvailabilityStatus().isBlank()) { throw new IllegalArgumentException("Book availabilityStatus is blank"); }
        if (!availabilityStatusTypes.contains(book.getAvailabilityStatus())) { throw new IllegalArgumentException("Book availabilityStatus does not exist"); }
        if (booksCatalogByTitle.containsKey(book.getTitle())) { throw new IllegalArgumentException("Book title already exists on the Catalog"); }

        // Add book to the Catalog
        booksCatalog.add(book);

        // Add book to the Catalog By Title
        booksCatalogByTitle.put(book.getTitle(), book);
    }

    public void removeBook(Book book) {

        // Validate book
        if (book.getTitle().isBlank()) { throw new IllegalArgumentException("Book title is blank"); }
        if (book.getAuthor().isBlank()) { throw new IllegalArgumentException("Book author is blank"); }
        if (book.getGenre().isBlank()) { throw new IllegalArgumentException("Book genre is blank"); }
        if (book.getAvailabilityStatus().isBlank()) { throw new IllegalArgumentException("Book availabilityStatus is blank"); }
        if (!availabilityStatusTypes.contains(book.getAvailabilityStatus())) { throw new IllegalArgumentException("Book availabilityStatus does not exist"); }

        // Add book to the Catalog
        booksCatalog.remove(book);

        // Add book to the Catalog By Title
        booksCatalogByTitle.remove(book.getTitle(), book);
    }

    public Book getBookByTitle(String title) {

        // Validate title is not blank
        if (title.isBlank()) { throw new IllegalArgumentException("Book title is blank"); }

        // Normalize title (trim spaces and standardize casing)
        title = title.trim();

        // Check if title contains invalid characters (basic example)
        if (!title.matches("[a-zA-Z0-9\\s,.!’'?-]+")) {
            throw new IllegalArgumentException("Book title contains invalid characters");
        }

        // Check if the book is on the catalog
        if (!booksCatalogByTitle.containsKey(title)) { throw new IllegalArgumentException("Book title does not exist on the Catalog"); }

        // Find book
        Book book = booksCatalogByTitle.get(title);

        return book;
    }

    public void viewBooksDetails(Book book) {
        // Display book info
        System.out.println();
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getGenre());
        System.out.println(book.getAvailabilityStatus());
        System.out.println();
    }

    public void viewAvailabilityStatus(Book book) {
        System.out.println();
        System.out.println(book.getTitle() + " - " + book.getAvailabilityStatus());
    }
}
