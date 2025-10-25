import exceptions.InvalidAuthorException;
import exceptions.InvalidBookException;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price)
    throws InvalidBookException, InvalidAuthorException {
        if (title == null || title.isEmpty()) {
            throw new InvalidBookException("Invalid book title");
        }
        if (author == null || author.isEmpty()) {
            throw new InvalidAuthorException("Invalid author name");
        }
        if (price <= 0) {
            throw new InvalidBookException("Invalid book price");
        }

        // birbaşa mənimsət
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printDetails() {
        System.out.printf("Title: %s - Author: %s - Price: %.2f%n", title, author, price);
    }
}
