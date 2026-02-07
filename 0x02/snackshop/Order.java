import java.util.LinkedHashSet;

public class Order {

    private LinkedHashSet<OrderItem> itemsInBox = new LinkedHashSet<>();
    private LinkedHashSet<OrderItem> itemsOutOfBox = new LinkedHashSet<>();

    public void addItemInBox(OrderItem item) {
        itemsInBox.add(item);
    }

    public void addItemOutOfBox(OrderItem item) {
        itemsOutOfBox.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Out of the Box:\n");
        for (OrderItem item : itemsOutOfBox) {
            sb.append(item.getType()).append(" ").append(item.getName()).append("\n");
        }

        sb.append("\nIn the Box:\n");
        for (OrderItem item : itemsInBox) {
            sb.append(item.getType()).append(" ").append(item.getName()).append("\n");
        }

        sb.append("\n");
        return sb.toString();
    }
}
