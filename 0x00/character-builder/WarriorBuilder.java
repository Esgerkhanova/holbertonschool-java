public class WarriorBuilder implements Builder {

    private String nome;
    private CharacterType type;
    private int intelligence;
    private int strength;
    private int endurance;
    private int resilience;
    private int dexterity;

    @Override
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public void setType(CharacterType type) { this.type = type; }

    @Override
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    @Override
    public void setStrength(int strength) { this.strength = strength; }

    @Override
    public void setEndurance(int endurance) { this.endurance = endurance; }

    @Override
    public void setResilience(int resilience) { this.resilience = resilience; }

    @Override
    public void setDexterity(int dexterity) { this.dexterity = dexterity; }

    public Warrior build() {
        if (type != null && type != CharacterType.WARRIOR) {
            throw new IllegalArgumentException("Invalid attributes for WARRIOR");
        }
        return new Warrior(nome, intelligence, strength, endurance, resilience, dexterity);
    }
}
