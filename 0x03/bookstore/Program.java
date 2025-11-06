import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.FRANCE);

        try {
            Book b1 = new Book("Robinson Crusoe", "Daniel Defoe", 56.00);
            b1.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            GoldEditionBook b2 = new GoldEditionBook("Frankenstein", "Mary Shelley", 38.30);
            b2.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            GoldEditionBook b4 = new GoldEditionBook("Alice’s Adventures in Wonderland",
                    "Lewis Carroll", 21.88);
            b4.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Book b3 = new Book("", "Bram Stoker", 15.99);
            b3.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Book b5 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 0);
            b5.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
