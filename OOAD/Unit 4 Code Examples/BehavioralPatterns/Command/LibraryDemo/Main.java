public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        // Commands
        LibraryCommand issue = new IssueBookCommand(library, "Java Programming");
        LibraryCommand returnCmd = new ReturnBookCommand(library, "Java Programming");

        // Invoker
        Librarian librarian = new Librarian();

        librarian.setCommand(issue);
        librarian.processRequest();   // Book issued

        librarian.setCommand(returnCmd);
        librarian.processRequest();   // Book returned
    }
}