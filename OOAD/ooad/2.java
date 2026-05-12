Implement the following use case using a proxy pattern. Write both
the class diagram and the code snippet. State which type of proxy pattern
is suitable for the given use case.
Use Case: If an entire library of books, with all the details about each
book, is loaded from a database, it will consume a lot of RAM, and it is
very likely that the user will need to issue or return only one book. The
solution, that uses the proxy design pattern, displays only the name,
author, and availability of the books when a list of them is displayed.
When a book is selected, all of the remaining details will be fetched from
the database and operations like issue/return (update availability) can be
performed.
Note: write only code snippets/pseudo code

Pseudo Code / Code Snippet
interface Book {

    void displayBasicInfo();

    void displayFullDetails();

    void issueBook();

    void returnBook();
}

Real Subject
class RealBook implements Book {

    String title;
    String author;
    boolean available;

    String publisher;
    int pages;
    String edition;

    RealBook(String title) {

        this.title = title;

        loadFromDatabase();
    }

    void loadFromDatabase() {

        System.out.println("Fetching full book details from DB...");
    }

    public void displayBasicInfo() {

        System.out.println(title + " " + author);
    }

    public void displayFullDetails() {

        System.out.println(title);
        System.out.println(author);
        System.out.println(publisher);
        System.out.println(edition);
        System.out.println(pages);
    }

    public void issueBook() {

        available = false;
    }

    public void returnBook() {

        available = true;
    }
}
Proxy Class
class BookProxy implements Book {

    private String title;
    private String author;
    private boolean available;

    private RealBook realBook;

    BookProxy(String title, String author,
              boolean available) {

        this.title = title;
        this.author = author;
        this.available = available;
    }

    public void displayBasicInfo() {

        System.out.println(title + " " +
                           author + " " +
                           available);
    }

    private void loadRealBook() {

        if(realBook == null) {

            realBook = new RealBook(title);
        }
    }

    public void displayFullDetails() {

        loadRealBook();

        realBook.displayFullDetails();
    }

    public void issueBook() {

        loadRealBook();

        realBook.issueBook();
    }

    public void returnBook() {

        loadRealBook();

        realBook.returnBook();
    }
}
Client Code
public class Main {

    public static void main(String[] args) {

        Book book =
            new BookProxy("Java", "James", true);

        // Lightweight operation
        book.displayBasicInfo();

        // Full details loaded only now
        book.displayFullDetails();
    }
}