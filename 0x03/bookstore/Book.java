import exceptions.InvalidAuthorException;
import exceptions.InvalidBookException;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
           if (title == null || title.isEmpty()) {
            throw new Exception("Invalid book title");
        }
        if (author == null || author.isEmpty()) {
            throw new Exception("Invalid author name");
        }
        if (price <= 0) {
            throw new Exception("Invalid book price");
        }
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }
  
     public void printDetails() {
        System.out.printf("Title: %s - Author: %s - Price: %.2f%n", title, author, price);
    }
}
