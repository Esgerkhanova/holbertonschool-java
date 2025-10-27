public class CharacterGame {
    private int currentHealth;
    private String name;

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void takeDamage(int damageAmount) {
        int newHealth = this.currentHealth - damageAmount;

        this.currentHealth = Math.max(0, newHealth);
    }

  
    public void receiveHealing(int healingAmount) {
        int newHealth = this.currentHealth + healingAmount;
        this.currentHealth = Math.min(100, newHealth);
    }
}
