import java.util.HashSet;
import java.util.Set;

public class Order {

    private HashSet<OrderItem> itemsInBox = new HashSet<>();
    private HashSet<OrderItem> itemsOutOfBox = new HashSet<>();

    public void addItemInBox(OrderItem item) {
        itemsInBox.add(item);
    }

    public void addItemOutOfBox(OrderItem item) {
        itemsOutOfBox.add(item);
    }

    public Set<OrderItem> getItemsInBox() {
        return itemsInBox;
    }

    public Set<OrderItem> getItemsOutOfBox() {
        return itemsOutOfBox;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\tOut of the Box:\n");
        for (OrderItem item : itemsOutOfBox) {
            sb.append("\t\t- ").append(item).append("\n");
        }

        sb.append("\tIn the Box:\n");
        for (OrderItem item : itemsInBox) {
            sb.append("\t\t- ").append(item).append("\n");
        }

        return sb.toString();
    }
}
