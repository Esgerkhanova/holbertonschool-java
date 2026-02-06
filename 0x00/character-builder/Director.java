public class Director {

    public void buildWarrior(Builder builder) {
        builder.setNome("Warrior");
        builder.setType(CharacterType.WARRIOR);
        builder.setIntelligence(1);
        builder.setStrength(8);
        builder.setDexterity(6);
        builder.setEndurance(5);
        builder.setResilience(10);
    }

    public void buildThief(Builder builder) {
        builder.setNome("Thief");
        builder.setType(CharacterType.THIEF);
        builder.setIntelligence(2);
        builder.setStrength(6);
        builder.setDexterity(10);
        builder.setEndurance(8);
        builder.setResilience(5);
    }

    public void buildMage(Builder builder) {
        builder.setNome("Mage");
        builder.setType(CharacterType.MAGE);
        builder.setIntelligence(10);
        builder.setStrength(2);
        builder.setDexterity(4);
        builder.setEndurance(5);
        builder.setResilience(3);
    }
}
