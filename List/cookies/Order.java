import java.util.ArrayList;

public class Order {
    private ArrayList<CookieOrder> cookies;

    public Order() {
        cookies = new ArrayList<>();
    }

    public void addCookieOrder(CookieOrder order) {
        cookies.add(order);
    }

    public int getTotalBoxes() {
        int total = 0;
        for (CookieOrder order : cookies) {
            total += order.getBoxQuantity();
        }
        return total;
    }

    public int removeFlavor(String flavor) {
        int totalRemoved = 0;
        ArrayList<CookieOrder> toRemove = new ArrayList<>();

        for (CookieOrder order : cookies) {
            if (order.getFlavor().equals(flavor)) {
                totalRemoved += order.getBoxQuantity();
                toRemove.add(order);
            }
        }

        cookies.removeAll(toRemove);
        return totalRemoved;
    }
}
