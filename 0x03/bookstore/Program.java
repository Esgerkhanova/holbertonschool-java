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
            Book b2 = new Book("Frankenstein", "Mary Shelley", 49.79);
            b2.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Book b4 = new Book("Dracula", "", 15.99);
            b4.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Book b3 = new Book("", "Lewis Carroll", 28.44);
            b3.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Book b5 = new Book("Some Book", "Unknown", -10);
            b5.printDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    
        System.out.println();
        System.out.flush();
    }
}
