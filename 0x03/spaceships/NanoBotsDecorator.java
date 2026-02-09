public class NanoBotsDecorator extends SpacecraftDecorator {

    public NanoBotsDecorator(Spacecraft spacecraftDecorated) {
        super(spacecraftDecorated);
    }

    @Override
    public int getAttack() {
  
        if (spacecraftDecorated instanceof ArmorDecorator) {
            return spacecraftDecorated.getAttack();
        }
        return spacecraftDecorated.getAttack() + 25;
    }
}
