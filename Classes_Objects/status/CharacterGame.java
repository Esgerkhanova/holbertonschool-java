public class CharacterGame {
    private int currentHealth;
    private String name;
    private String status; 



    public int getCurrentHealth() {
        return currentHealth;
    }
  
    public void setCurrentHealth(int currentHealth) {
        int clampedHealth = Math.min(100, Math.max(0, currentHealth));
        this.currentHealth = clampedHealth;
        if (this.currentHealth > 0) {
            this.status = "alive";
        } else {
            this.status = "dead";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }


    public void takeDamage(int damageAmount) {
        int newHealth = this.currentHealth - damageAmount;
        setCurrentHealth(newHealth);
    }

    public void receiveHealing(int healingAmount) {
        int newHealth = this.currentHealth + healingAmount;
        setCurrentHealth(newHealth);
    }
}
