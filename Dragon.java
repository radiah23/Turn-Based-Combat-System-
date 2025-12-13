import java.util.Random;
class Dragon extends CombatEntity implements AIControlled {
    public Dragon(String name) {
        super(name, 150,20);
    }
    
    @Override
    public String attack(CombatEntity target){
        return target.takeHit(basePower, name);


    }

    @Override
    public String takeTurn(CombatEntity target){
        Random rand = new Random();
        int number = rand.nextInt(20)+1; // 20 --> 0-19, +1 so that 1 is added to add 1 to 20 

        if (number < 16){
            return attack(target);
        }

        if(number == 16 || number == 17 || number == 18 || number == 19){
            int damage = basePower * 3;
            target.takeHit(damage, name);
            return name + "scorched" + target.getName() + "with searing fire, dealing"+ damage + "damage";

        }

        if(number == 20){
            int damage = basePower * 3;
            target.takeHit(damage, name);
            int before = curHealth;
            curHealth = Math.min(maxHealth, curHealth+20);
            int healed = curHealth-before;
            return name + "took a bite out of"+ target.getName()+ "dealing" + damage +"damage and recovering"+ healed+ "health!";
            
        }

        return " ";







    }












}
