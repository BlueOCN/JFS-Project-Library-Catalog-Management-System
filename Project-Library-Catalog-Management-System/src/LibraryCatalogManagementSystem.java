import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCatalogManagementSystem {
    public static void main(String[] args) {

        boolean masterSwitch = true;
        int systemState = 0b0001;     // State: FSM starts always on Idle

        Catalog libraryCatalog = new Catalog();
        Scanner scanner = new Scanner(System.in);
        char res;

        do {

            switch (systemState) {

                case 0b0001:   // Idle: Setup State, executed only once.

                    // Create Books
                    Book book1 = new Book("Whispers of the Forgotten City", "Isabella Thornfield", "Mystery/Thriller", "Available");
                    Book book2 = new Book("The Clockmaker’s Dilemma","Victor Moriarty","Fantasy","Checked Out");
                    Book book3 = new Book("Echoes from the Abyss","Elena Vasquez","Science Fiction","Reserved");
                    Book book4 = new Book("The Moonlight Pact","Samuel D. Holloway","Historical Fiction","Lost");

                    // Create Book dataset
                    ArrayList<Book> bookDataset = new ArrayList<>();

                    // Fill Book dataset
                    bookDataset.add(book1);
                    bookDataset.add(book2);
                    bookDataset.add(book3);
                    bookDataset.add(book4);

                    // Create Catalog with the Book dataset
                    libraryCatalog = new Catalog(bookDataset);

                    systemState = 0b0010;

                    break;

                case 0b0010:   // Start: Start State, Application Home

                    System.out.println();
                    System.out.println("Welcome to the Library Catalog Management System");
                    System.out.println("System Description");
                    System.out.println();
                    System.out.println("1 - Add Book");
                    System.out.println("2 - Remove Book");
                    System.out.println("10 - View Book Details");
                    System.out.println("20 - Check Book Availability");
                    System.out.println("100 - Restart");
                    System.out.println("0 - Exit");

                    // Validate user input
                    int userInput;
                    while (true) {
                        System.out.print("\nWhat do you want to do? (Enter a number between 1 and 100): ");

                        // Check if input is an integer
                        if (scanner.hasNextInt()) {
                            userInput = scanner.nextInt();

                            // Validate range
                            if (userInput >= 1 && userInput <= 100) {
                                break; // Exit loop if input is valid
                            } else {
                                System.out.println("Error: Please enter a number between 1 and 100.");
                            }
                        } else {
                            System.out.println("Error: Invalid input. Please enter a number.");
                            scanner.next(); // Clear invalid input
                        }
                    }

                    switch (userInput) {
                        case 1:     // Go to Add Book State
                            systemState = 0b0011;
                            break;

                        case 2:     // Go to Remove Book State
                            systemState = 0b0100;
                            break;

                        case 10:    // Go to View Book Details State
                            systemState = 0b0101;
                            break;

                        case 20:    // Go to Check Book Availability State
                            systemState = 0b0110;
                            break;

                        case 100:   // Go to Idle State
                            systemState = 0b0001;
                            break;

                        default:    // Shutdown System
                            systemState = 0b0001;
                            masterSwitch = false;
                            break;
                    }
                    break;

                case 0b0011:    // Add Book State

                    // Prompt user for new books data
                    String title, author, genre, availabilityStatus;
                    scanner = new Scanner(System.in);

                    System.out.println("New Book Information");
                    System.out.print("\nEnter title: ");
                    title = scanner.nextLine().strip();
                    Catalog.validateTitle(title);
                    System.out.print("Enter author: ");
                    author = scanner.nextLine().strip();
                    Catalog.validateAuthor(author);
                    System.out.print("Enter genre: ");
                    genre = scanner.nextLine().strip();
                    Catalog.validateGenre(genre);
                    System.out.print("Enter availabilityStatus: ");
                    availabilityStatus = scanner.nextLine().strip();
                    Catalog.validateAvailabilityStatus(availabilityStatus);

                    // Display book info
                    System.out.println();
                    System.out.println(title);
                    System.out.println(author);
                    System.out.println(genre);
                    System.out.println(availabilityStatus);
                    System.out.println();

                    // Validate Data
                    while (true) {
                        System.out.print("Is the data captured correctly? [Y/N]: ");
                        String input = scanner.nextLine().strip().toUpperCase();

                        // Validate input
                        if (input.length() == 1 && (input.charAt(0) == 'Y' || input.charAt(0) == 'N')) {
                            res = input.charAt(0);
                            break; // Exit loop if valid input
                        } else {
                            System.out.println("Error: Please enter 'Y' or 'N' only.");
                        }
                    }

                    if (res == 'Y') {

                        // Create new book
                        Book newBook = new Book(title, author, genre, availabilityStatus);

                        // Add new book to the catalog
                        libraryCatalog.addBook(newBook);

                        // Update the user
                        System.out.println("New Book Added");

                        // Go to Start
                        systemState = 0b0010;

                    } else {
                        // Capture data again
                        systemState = 0b0011;
                    }
                    break;

                case 0b0100:    // Remove Book State

                    // Prompt the user for book info
                    String bookTitle;
                    scanner = new Scanner(System.in);

                    System.out.print("\nEnter title: ");
                    bookTitle = scanner.nextLine().strip();

                    // Validate Data
                    while (true) {
                        System.out.print("Is the data captured correctly? [Y/N]: ");
                        String input = scanner.nextLine().strip().toUpperCase();

                        // Validate input
                        if (input.length() == 1 && (input.charAt(0) == 'Y' || input.charAt(0) == 'N')) {
                            res = input.charAt(0);
                            break; // Exit loop if valid input
                        } else {
                            System.out.println("Error: Please enter 'Y' or 'N' only.");
                        }
                    }

                    if (res == 'Y') {
                        // Find the book on the catalog
                        Book book = libraryCatalog.getBookByTitle(bookTitle);

                        // Display book details
                        libraryCatalog.viewBooksDetails(book);

                        // Remove book of the catalog
                        libraryCatalog.removeBook(book);

                        // Update the user
                        System.out.println("Book Removed");

                        // Go to Start
                        systemState = 0b0010;
                    } else {
                        // Capture data again
                        systemState = 0b0100;
                    }
                    break;

                case 0b0101:    // View Book Details State

                    // Prompt the user for book info
                    String bookTitle3;
                    scanner = new Scanner(System.in);

                    System.out.print("\nEnter title: ");
                    bookTitle3 = scanner.nextLine().strip();

                    // Validate Data
                    while (true) {
                        System.out.print("Is the data captured correctly? [Y/N]: ");
                        String input = scanner.nextLine().strip().toUpperCase();

                        // Validate input
                        if (input.length() == 1 && (input.charAt(0) == 'Y' || input.charAt(0) == 'N')) {
                            res = input.charAt(0);
                            break; // Exit loop if valid input
                        } else {
                            System.out.println("Error: Please enter 'Y' or 'N' only.");
                        }
                    }

                    if (res == 'Y') {
                        // Find the book on the catalog
                        Book book = libraryCatalog.getBookByTitle(bookTitle3);

                        // Display book details
                        libraryCatalog.viewBooksDetails(book);

                        // Go to Start
                        systemState = 0b0010;
                    } else {
                        // Capture data again
                        systemState = 0b0101;
                    }
                    break;

                case 0b0110:    // Check Book Availability State

                    // Prompt the user for book info
                    String bookTitle2;
                    scanner = new Scanner(System.in);

                    System.out.print("\nEnter title: ");
                    bookTitle2 = scanner.nextLine().strip();

                    // Validate Data
                    while (true) {
                        System.out.print("Is the data captured correctly? [Y/N]: ");
                        String input = scanner.nextLine().strip().toUpperCase();

                        // Validate input
                        if (input.length() == 1 && (input.charAt(0) == 'Y' || input.charAt(0) == 'N')) {
                            res = input.charAt(0);
                            break; // Exit loop if valid input
                        } else {
                            System.out.println("Error: Please enter 'Y' or 'N' only.");
                        }
                    }

                    if (res == 'Y') {
                        // Find the book on the catalog
                        Book book = libraryCatalog.getBookByTitle(bookTitle2);

                        // Display book availabilityStatus
                        libraryCatalog.viewAvailabilityStatus(book);

                        // Go to Start
                        systemState = 0b0010;
                    } else {
                        // Capture data again
                        systemState = 0b0110;
                    }
                    break;

                default:
                    masterSwitch = false;
                    break;
            }


        } while (masterSwitch);
    }
}