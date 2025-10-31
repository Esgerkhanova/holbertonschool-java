public class Dvd extends Product {
    private String director;
    private String genre;
    private int duration;

    public Dvd(String title, int year, String country, double grossPrice,
               String director, String genre, int duration) {
        super(title, year, country, grossPrice);
        this.director = director;
        this.genre = genre;
        this.duration = duration;
    }
 public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }
    @Override
    public double getNetPrice() {
        return getGrossPrice() * 1.20;
    }
}
