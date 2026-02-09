public class NanoBotsDecorator extends SpacecraftDecorator {

    public NanoBotsDecorator(Spacecraft spacecraftDecorated) {
        super(spacecraftDecorated);
    }

    @Override
    public int getAttack() {
        return spacecraftDecorated.getAttack() + 25;
    }
}
