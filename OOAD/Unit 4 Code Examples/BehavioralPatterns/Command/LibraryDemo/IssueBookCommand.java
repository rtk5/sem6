// Concrete Command
class IssueBookCommand implements LibraryCommand {
    private Library library;
    private String bookName;

    public IssueBookCommand(Library library, String bookName) {
        this.library = library;
        this.bookName = bookName;
    }

    @Override
    public void execute() {
        library.issueBook(bookName);
    }
}