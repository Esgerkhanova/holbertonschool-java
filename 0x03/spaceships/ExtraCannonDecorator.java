public class ExtraCannonDecorator extends SpacecraftDecorator {

    public ExtraCannonDecorator(Spacecraft spacecraftDecorated) {
        super(spacecraftDecorated);
    }

    @Override
    public int getAttack() {
        return spacecraftDecorated.getAttack() + 75;
    }
}
