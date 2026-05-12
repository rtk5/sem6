3.a. A library management system needs to keep track of books borrowed
by members. Each member can borrow multiple books, and the system
must calculate the total number of books borrowed by all members in the
library. Using the Information Expert principle, identify which class should
be responsible for calculating the total number of borrowed books. Justify
your choice and design the solution.


Answer
Library
-------------------------
- members : List<Member>
-------------------------
+ addMember()
+ calculateTotalBorrowedBooks()

Member
-------------------------
- borrowedBooks : List<Book>
-------------------------
+ borrowBook()
+ getBorrowedBookCount()

Book
-------------------------
- bookId
- title
- author


import java.util.*;

class Book {
    String title;

    Book(String title) {
        this.title = title;
    }
}

class Member {

    List<Book> borrowedBooks = new ArrayList<>();

    void borrowBook(Book b) {
        borrowedBooks.add(b);
    }

    int getBorrowedBookCount() {
        return borrowedBooks.size();
    }
}

class Library {

    List<Member> members = new ArrayList<>();

    void addMember(Member m) {
        members.add(m);
    }

    int calculateTotalBorrowedBooks() {

        int total = 0;

        for (Member m : members) {
            total += m.getBorrowedBookCount();
        }

        return total;
    }
}

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book("Java");
        Book b2 = new Book("Python");

        Member m1 = new Member();
        m1.borrowBook(b1);

        Member m2 = new Member();
        m2.borrowBook(b2);

        Library lib = new Library();

        lib.addMember(m1);
        lib.addMember(m2);

        System.out.println("Total Borrowed Books = "
                + lib.calculateTotalBorrowedBooks());
    }
}

