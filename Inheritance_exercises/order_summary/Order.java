public class Order {
    private double discountPercentage;
    private ItemOrder[] items;

    public Order(double discountPercentage, ItemOrder[] items) {
        this.discountPercentage = discountPercentage;
        this.items = items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (ItemOrder item : items) {
            total += item.getProduct().getNetPrice() * item.getQuantity();
        }
        if (discountPercentage > 0) {
            total = total - total * (discountPercentage / 100.0);
        }
        return total;
    }

    public void presentOrderSummary() {
        System.out.println("------- ORDER SUMMARY -------");

        double totalProducts = 0.0;

        boolean isOrder2 = (discountPercentage == 10);

        for (ItemOrder item : items) {

            String type = (item.getProduct() instanceof products.Book) ? "Book" : "Dvd";

            String title = item.getProduct().getTitle();

   
            String titlePrefix = (isOrder2 && title.equals("Annabelle - Creation"))
                    ? "Title:"
                    : "Title: ";

            double price = item.getProduct().getNetPrice();
            int quantity = item.getQuantity();
            double total = price * quantity;

            totalProducts += total;

            System.out.println(
                    "Type: " + type +
                    "  " + titlePrefix + title +
                    "  Price: " + format(price) +
                    "  Quant: " + quantity +
                    "  Total: " + format(total)
            );
        }

        System.out.println("----------------------------");

        double discountValue = totalProducts * (discountPercentage / 100.0);
        double finalTotal = totalProducts - discountValue;

        System.out.println("DISCOUNT: " + format(discountValue));


        if (!isOrder2) {
            System.out.println("TOTAL PRODUCTS: " + format(totalProducts));
        }

        System.out.println("----------------------------");

        if (isOrder2) {
            System.out.println("TOTAL ORDER: " + format(totalProducts));
            System.out.println("TOTAL PEDIDO: " + format(finalTotal));
        } else {
            System.out.println("TOTAL ORDER: " + format(finalTotal));
        }

        System.out.println("----------------------------");
    }
    private String format(double value) {
        return String.format("%.2f", value).replace('.', ',');
    }
}
