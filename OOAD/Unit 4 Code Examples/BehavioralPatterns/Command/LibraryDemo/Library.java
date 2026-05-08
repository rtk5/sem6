// Receiver (Actual command execution)
class Library {
    public void issueBook(String bookName) {
        System.out.println("Book issued: " + bookName);
    }

    public void returnBook(String bookName) {
        System.out.println("Book returned: " + bookName);
    }
}