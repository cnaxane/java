package assignment9;

class Book {
    final String isbn;
    String title;
    String author;
    double price;

    Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class LibraryBook {
    public static void main(String[] args) {
        Book book = new Book(
            "978-0135166307",
            "Java Programming",
            "James Gosling",
            799
        );

        book.display();
    }
}
