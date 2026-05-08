// Concrete command
class ReturnBookCommand implements LibraryCommand {
    private Library library;
    private String bookName;

    public ReturnBookCommand(Library library, String bookName) {
        this.library = library;
        this.bookName = bookName;
    }

    @Override
    public void execute() {
        library.returnBook(bookName);
    }
}