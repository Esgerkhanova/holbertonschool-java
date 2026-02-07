import java.util.HashSet;

public class Order {

    private HashSet<OrderItem> itemsInBox = new HashSet<>();
    private HashSet<OrderItem> itemsOutOfBox = new HashSet<>();

    public void addItemInBox(OrderItem item) {
        itemsInBox.add(item);
    }

    public void addItemOutOfBox(OrderItem item) {
        itemsOutOfBox.add(item);
    }

    private void appendFirstMatch(StringBuilder sb, HashSet<OrderItem> set, OrderItemType type) {
        for (OrderItem item : set) {
            if (item.getType() == type) {
                sb.append(item.getType()).append(" ").append(item.getName()).append("\n");
                return;
            }
        }
    }
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Out of the Box:\n\n");
    for (OrderItem item : itemsOutOfBox) {
        if (item.getType() == OrderItemType.DRINK) {
            sb.append(item.getType()).append(" ").append(item.getName()).append("\n");
            break;
        }
    }

    sb.append("\nIn the Box:\n");
    
    for (OrderItem item : itemsInBox) {
        if (item.getType() == OrderItemType.TOY) {
            sb.append(item.getType()).append(" ").append(item.getName()).append("\n");
            break;
        }
    }
    for (OrderItem item : itemsInBox) {
        if (item.getType() == OrderItemType.FRIES) {
            sb.append(item.getType()).append(" ").append(item.getName()).append("\n");
            break;
        }
    }
    for (OrderItem item : itemsInBox) {
        if (item.getType() == OrderItemType.SNACK) {
            sb.append(item.getType()).append(" ").append(item.getName()).append("\n");
            break;
        }
    }

    sb.append("\n");
    return sb.toString();
}

}
