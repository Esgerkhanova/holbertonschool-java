package products;

public abstract class Product {
    private String title;
    private int year;
    private String country;
    private double grossPrice;

    public Product(String title, int year, String country, double grossPrice) {
        this.title = title;
        this.year = year;
        this.country = country;
        this.grossPrice = grossPrice;
    }

    public abstract double getNetPrice();

    public String getTitle() { return title; }
    public double getGrossPrice() { return grossPrice; }
    public int getYear() { return year; }
    public String getCountry() { return country; }
}
