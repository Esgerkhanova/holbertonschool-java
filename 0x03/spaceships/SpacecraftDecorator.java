public class SpacecraftDecorator extends Spacecraft {

    private Spacecraft spacecraftDecorated;

    public SpacecraftDecorator(Spacecraft spacecraftDecorated) {
        super(spacecraftDecorated.getHealth(), spacecraftDecorated.getAttack());
        this.spacecraftDecorated = spacecraftDecorated;
    }

    @Override
    public int getHealth() {
        return spacecraftDecorated.getHealth();
    }

    @Override
    public int getAttack() {
        return spacecraftDecorated.getAttack();
    }
}
