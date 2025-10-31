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

    for (ItemOrder item : items) {
        String type = (item.getProduct() instanceof products.Book) ? "Book" : "Dvd";
        String title = item.getProduct().getTitle();
        double price = item.getProduct().getNetPrice();
        int quantity = item.getQuantity();
        double total = price * quantity;

        totalProducts += total;

        System.out.printf(
            "Type: %s  Title: %s  Price: %.2f  Quant: %d  Total: %.2f\n",
            type, title, price, quantity, total
        );
    }

    System.out.println("----------------------------");

    double discountValue = totalProducts * (discountPercentage / 100.0);
    double finalTotal = totalProducts - discountValue;

    System.out.printf("DISCOUNT: %.2f\n", discountValue);
    System.out.printf("TOTAL PRODUCTS: %.2f\n", totalProducts);
    System.out.println("----------------------------");
    System.out.printf("TOTAL ORDER: %.2f\n", finalTotal);
    System.out.println("----------------------------");
}

}
