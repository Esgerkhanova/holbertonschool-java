public class LaserDecorator extends SpacecraftDecorator {

    public LaserDecorator(Spacecraft spacecraftDecorated) {
        super(spacecraftDecorated);
    }

    @Override
    public int getAttack() {
        return spacecraftDecorated.getAttack() + 40;
    }
}
