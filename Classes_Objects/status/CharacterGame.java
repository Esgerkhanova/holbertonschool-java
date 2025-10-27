public class CharacterGame {
    private int currentHealth;
    private String name;
    private String status;

  
    public CharacterGame(int initialHealth, String initialName) {
        this.name = "Unknown Character"; 
        setName(initialName);
     
        setCurrentHealth(initialHealth);
    }



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
        // Validation: Reject null or empty strings
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getStatus() {
        return status;
    }

    // --- Methods ---

    public void takeDamage(int damageAmount) {
        int newHealth = this.currentHealth - damageAmount;
        setCurrentHealth(newHealth);
    }

    public void receiveHealing(int healingAmount) {
        int newHealth = this.currentHealth + healingAmount;
        setCurrentHealth(newHealth);
    }
}
