import java.util.Scanner;

class Wizard extends CombatEntity implements PlayerControlled {

    public Wizard(String name) {
        super(name, 100,15);  
     
    }

    @Override
    public String attack(CombatEntity target){
        return target.takeHit(basePower, name);


    }

    @Override
    public String chooseAction(Scanner input, CombatEntity target){
        System.out.println("0. Retreat 1. Simple Attack 2. Heal (Spell) 3. Undo (Spell)");
        int choice = -1;
        //hasNextInt will keep running as long as the user is not giving a new input
        while(!input.hasNextInt()){
            input.next(); //abcd wont work here,only int will work. Looping continue if its anything except int as welll
        
        }
        choice = input.nextInt();
        while(choice < 0 || choice > 3 ){ 
            // suppose if the user inputs 4, then the while loop that we used before is going to continue 
            while(!input.hasNextInt()){
                input.next(); 
            
            }
            choice = input.nextInt();


        }
        if(choice == 0){
            return "RETREAT";
        }

        if (choice == 1){
            return attack(target);

        }

        if(choice == 2){
            return recover(20, name);
        }

        return "UNDO";


    }

}






