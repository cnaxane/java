package assignment12;

public class Main2 {
    public static void main(String[] args) {
        Book b = new Book(101, "Java Programming", "James Gosling", 799);

        System.out.println("Book Details");
        b.display();
    }
}

class Book {
    private final int id;
    private final String title;
    private final String author;
    private final int price;

    Book(int id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
