import java.util.Objects;

public class OrderItem {
    private OrderItemType type;
    private String name;

    public OrderItem(OrderItemType type, String name) {
        this.type = type;
        this.name = name;
    }

    public OrderItemType getType() {
        return type;
    }

    public void setType(OrderItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return type == orderItem.type && Objects.equals(name, orderItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
