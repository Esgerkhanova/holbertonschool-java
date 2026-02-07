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
        appendFirstMatch(sb, itemsOutOfBox, OrderItemType.DRINK);

        sb.append("\nIn the Box:\n");
        appendFirstMatch(sb, itemsInBox, OrderItemType.TOY);
        appendFirstMatch(sb, itemsInBox, OrderItemType.FRIES);
        appendFirstMatch(sb, itemsInBox, OrderItemType.SNACK);

        sb.append("\n");
        return sb.toString();
    }
}
