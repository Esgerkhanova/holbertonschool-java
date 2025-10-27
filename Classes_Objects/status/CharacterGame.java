public class CharacterGame {
    private String name;
    private int currentHealth;
    private String status; 


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    
    public void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) {
            this.currentHealth = 0;
        } else {
            this.currentHealth = currentHealth;
        }

        if (this.currentHealth == 0) {
            this.status = "dead";
        } else {
            this.status = "alive";
        }
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

  
    public String getStatus() {
        return status;
    }


    public void takeDamage(int damage) {
        setCurrentHealth(this.currentHealth - damage);
    }

   
    public void receiveHealing(int heal) {
        setCurrentHealth(this.currentHealth + heal);
    }
}
