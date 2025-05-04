import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCatalogManagementSystem {
    public static void main(String[] args) {

        boolean masterSwitch = true;
        char systemState = 'I';     // State: FSM starts always on Idle

        Catalog libraryCatalog = new Catalog();
        Scanner scanner = new Scanner(System.in);

        do {

            switch (systemState) {

                case 'I':   // Idle: Setup State, executed only once.

                    // Create Books
                    Book book1 = new Book();
                    Book book2 = new Book();
                    Book book3 = new Book();
                    Book book4 = new Book();

                    // Create Book dataset
                    ArrayList<Book> bookDataset = new ArrayList<>();

                    // Fill Book dataset
                    bookDataset.add(book1);
                    bookDataset.add(book2);
                    bookDataset.add(book3);
                    bookDataset.add(book4);

                    // Create Catalog with the Book dataset
                    libraryCatalog = new Catalog(bookDataset);

                    systemState = 'S';

                    break;

                case 'S':   // Start: Start State, Application Home

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
                    System.out.print("\nWhat do you want to do? (Enter a number between 1 and 100): ");
                    int userInput = scanner.nextInt(); // TODO - Validation: filter user input
                    switch (userInput) {
                        case 1:     // Go to Add Book State
                            systemState = '1';
                            break;

                        case 2:     // Go to Remove Book State
                            systemState = '2';
                            break;

                        case 10:    // Go to View Book Details State
                            systemState = 'A';
                            break;

                        case 20:    // Go to Check Book Availability State
                            systemState = 'B';
                            break;

                        case 100:   // Go to Idle State
                            systemState = 'I';
                            break;

                        default:    // Shutdown System
                            systemState = 'I';
                            masterSwitch = false;
                            break;
                    }
                    break;

                case '1':

                    // Prompt user for new books data
                    String title, author, genre, availabilityStatus;
                    scanner = new Scanner(System.in);

                    System.out.println("New Book Information");
                    System.out.print("\nEnter title: ");
                    title = scanner.nextLine().strip(); // TODO - Validation: filter user input
                    System.out.print("Enter author: ");
                    author = scanner.nextLine().strip(); // TODO - Validation: filter user input
                    System.out.print("Enter genre: ");
                    genre = scanner.nextLine().strip(); // TODO - Validation: filter user input
                    System.out.print("Enter availabilityStatus: ");
                    availabilityStatus = scanner.nextLine().strip(); // TODO - Validation: filter user input

                    // Display book info
                    System.out.println();
                    System.out.println(title);
                    System.out.println(author);
                    System.out.println(genre);
                    System.out.println(availabilityStatus);
                    System.out.println();

                    // Validate Data
                    System.out.print("Is the data captured correctly? [Y/N]: ");
                    char res = scanner.nextLine().strip().toUpperCase().charAt(0); // TODO - Validation: filter user input

                    if (res == 'Y') {

                        // Create new book
                        Book newBook = new Book(title, author, genre, availabilityStatus);

                        // Add new book to the catalog
                        libraryCatalog.addBook(newBook);

                        // View new book details
                        libraryCatalog.viewBooksDetails(newBook);

                        // Go to Start
                        systemState = 'S';

                    } else {
                        // Capture data again
                        systemState = '1';
                    }
                    break;

                case '2':

                    // Prompt the user for book info
                    String bookTitle;
                    scanner = new Scanner(System.in);

                    System.out.print("\nEnter title: ");
                    bookTitle = scanner.nextLine().strip();

                    // Validate Data
                    System.out.print("Is the data captured correctly? [Y/N]: ");
                    char resp = scanner.nextLine().strip().toUpperCase().charAt(0); // TODO - Validation: filter user input

                    if (resp == 'Y') {
                        // Find the book on the catalog
                        Book book = libraryCatalog.getBookByTitle(bookTitle);

                        // Display book details
                        libraryCatalog.viewBooksDetails(book);

                        // Remove book of the catalog
                        libraryCatalog.removeBook(book);

                        // Go to Start
                        systemState = 'S';
                    } else {
                        // Capture data again
                        systemState = '2';
                    }
                    break;

                case 'A':

                    // Prompt the user for book info
                    String bookTitle3;
                    scanner = new Scanner(System.in);

                    System.out.print("\nEnter title: ");
                    bookTitle3 = scanner.nextLine().strip();

                    // Validate Data
                    System.out.print("Is the data captured correctly? [Y/N]: ");
                    char resp3 = scanner.nextLine().strip().toUpperCase().charAt(0); // TODO - Validation: filter user input

                    if (resp3 == 'Y') {
                        // Find the book on the catalog
                        Book book = libraryCatalog.getBookByTitle(bookTitle3);

                        // Display book details
                        libraryCatalog.viewBooksDetails(book);

                        // Go to Start
                        systemState = 'S';
                    } else {
                        // Capture data again
                        systemState = 'A';
                    }
                    break;

                case 'B':

                    // Prompt the user for book info
                    String bookTitle2;
                    scanner = new Scanner(System.in);

                    System.out.print("\nEnter title: ");
                    bookTitle2 = scanner.nextLine().strip();

                    // Validate Data
                    System.out.print("Is the data captured correctly? [Y/N]: ");
                    char res3 = scanner.nextLine().strip().toUpperCase().charAt(0); // TODO - Validation: filter user input

                    if (res3 == 'Y') {
                        // Find the book on the catalog
                        Book book = libraryCatalog.getBookByTitle(bookTitle2);

                        // Display book availabilityStatus
                        libraryCatalog.viewAvailabilityStatus(book);

                        // Go to Start
                        systemState = 'S';
                    } else {
                        // Capture data again
                        systemState = 'B';
                    }
                    break;

                default:
                    masterSwitch = false;
                    break;
            }


        } while (masterSwitch);
    }
}