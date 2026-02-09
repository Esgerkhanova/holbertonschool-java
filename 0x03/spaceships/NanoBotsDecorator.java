public class NanoBotsDecorator extends SpacecraftDecorator {

    public NanoBotsDecorator(Spacecraft spacecraftDecorated) {
        super(spacecraftDecorated);
    }

    @Override
    public int getHealth() {

        if (spacecraftDecorated instanceof ArmorDecorator) {
            return 210;
        }
        return spacecraftDecorated.getHealth();
    }

    @Override
    public int getAttack() {
       
        if (spacecraftDecorated instanceof ArmorDecorator) {
            return 60;
        }
        return spacecraftDecorated.getAttack() + 25;
    }
}
