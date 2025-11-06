import exceptions.InvalidAuthorException;
import exceptions.InvalidBookException;
import java.util.Locale;

public class Book {

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) throws Exception {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidBookException {
        if (title == null || title.length() < 3) {
            throw new InvalidBookException("Invalid book title");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws InvalidAuthorException {
        if (author == null || author.trim().split("\\s+").length < 2) {
            throw new InvalidAuthorException("Invalid author name");
        }
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidBookException {
        if (price <= 0) {
            throw new InvalidBookException("Invalid book price");
        }
