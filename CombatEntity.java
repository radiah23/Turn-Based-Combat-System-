abstract class CombatEntity {
    protected String name;
    protected int curHealth;
    protected int maxHealth;
    protected int basePower;
    public CombatEntity(String n, int h, int p) {
        this.name = n;
        this.maxHealth = h;
        this.basePower = p;
        this.curHealth = maxHealth;
    }
    
    public boolean hasLost() {
        if (curHealth <= 0) {
            return true;
        } else {
            return false;
        }
    }  
    public String takeHit(int damage, String source) {
        this.curHealth -= damage;
        return this.name + "takes a hit for" + damage + "damage from" + source;
    }
// I dont understand this method here lowkey
    public String recover(int amount, String source) {
        int before = this.curHealth;
        int after = this.curHealth + amount;
        this.curHealth = Math.min(maxHealth,after); //because it can not heal above max health
        int result = this.curHealth-before;
        return this.name + "recovers " + result + " health from " + source;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }
    public int getBasePower(){
        return this.basePower;
    }

// based on the homework instruction
    public void setHealth(int health) {
        this.curHealth = health;
    }
    
    public int getHealth() {
        return this.curHealth;
    }
// I dont know how to do it 
    public abstract String attack(CombatEntity target);
    }

 
