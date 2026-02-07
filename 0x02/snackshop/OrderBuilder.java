public class OrderBuilder extends OrderAbstractBuilder {

    private final Order order = new Order();

    private SnackType snack;
    private FriesSize fries;
    private ToyType toy;
    private DrinkType drink;

    @Override
    public void setSnack(SnackType type) {
        this.snack = type;
    }

    @Override
    public void setFries(FriesSize size) {
        this.fries = size;
    }

    @Override
    public void setToy(ToyType type) {
        this.toy = type;
    }

    @Override
    public void setDrink(DrinkType type) {
        this.drink = type;
    }

    public Order build() {
    
        if (drink != null) {
            order.addItemOutOfBox(new OrderItem(OrderItemType.DRINK, drink.name()));
        }

        if (toy != null) {
            order.addItemInBox(new OrderItem(OrderItemType.TOY, toy.name()));
        }
        if (fries != null) {
            order.addItemInBox(new OrderItem(OrderItemType.FRIES, fries.name()));
        }
        if (snack != null) {
            order.addItemInBox(new OrderItem(OrderItemType.SNACK, snack.name()));
        }

        return order;
    }
}
