public class Order {
    private double discountPercentage;
    private ItemOrder[] items;

    public Order(double discountPercentage, ItemOrder[] items) {
        this.discountPercentage = discountPercentage;
        this.items = items;
    }
   public double calculateTotal() {
        double subtotal = 0.0;

     
        for (ItemOrder item : items) {
           
            subtotal += item.getProduct().getNetPrice() * item.getQuantity();
        }

   
        double discountMultiplier = 1.0 - (discountPercentage / 100.0);

        return subtotal * discountMultiplier;
    }

  
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public ItemOrder[] getItems() {
        return items;
    }
   public String format(double value) {
      return String.format("%.2f", value).replace('.', ',');
}

}
