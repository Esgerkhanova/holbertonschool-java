public class ArmorDecorator extends SpacecraftDecorator {

    public ArmorDecorator(Spacecraft spacecraftDecorated) {
        super(spacecraftDecorated);
    }

    @Override
    public int getHealth() {
        return spacecraftDecorated.getHealth() + 150;
    }
}
