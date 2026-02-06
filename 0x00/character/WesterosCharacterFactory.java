public class WesterosCharacterFactory extends CharacterFactory {

    @Override
    public Character createCharacter(CharacterType type, String name) {
        switch (type) {
            case MAGE:
                return new Mage("Mage", 8, 3, 3, 3, 4);
            case THIEF:
                return new Thief("Thief", 1, 8, 7, 7, 10);
            case WARRIOR:
                return new Warrior("Warrior", 0, 9, 7, 10, 7);
            default:
                throw new IllegalArgumentException("Invalid character type");
        }
    }
}
