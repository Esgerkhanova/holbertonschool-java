import java.util.HashMap;
import java.util.Map;

public class Warehouse<T> implements Storable<T> {
    private Map<String, T> inventory;

    public Warehouse() {
        this.inventory = new HashMap<>();
    }

    @Override
    public void addToInventory(String name, T value) {
        inventory.put(name, value);
    }

    @Override
    public T getFromInventory(String name) {
        return inventory.get(name);
    }
}
