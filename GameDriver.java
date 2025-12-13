import java.util.Scanner;
public class GameDriver{
    private static GameState currentState;
    public static GameState
    getCurrentGameState() {
        return currentState;
    }
    


public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    Wizard wiz = new Wizard("Wizard");
    Dragon drag = new Dragon("Dragon");
    GameStack stack = new GameStack();
    System.out.println("The Game Starts!!");

    while(!wiz.hasLost() && !drag.hasLost()){
        System.out.println(wiz.getName() + "Health Power" + wiz.getHealth() + "Max Health" + wiz.getMaxHealth() + "Base Power" + wiz.getBasePower());
        System.out.println(drag.getName() + "Health Power" + drag.getHealth() + "Max Health" + drag.getMaxHealth() + "Base Power" + drag.getBasePower());


        CombatEntity[] arr = {wiz, drag};

        int[] health = {wiz.getHealth(), drag.getHealth()};

        currentState = new GameState(arr, health);

        stack.push(currentState);

        String action = wiz.chooseAction(scan, drag);

        System.out.println(action);

        if (action.equals("UNDO")){
            stack.pop();
            GameState previous = stack.peek();

            if (previous != null){
                for(int i = 0; i < previous.getSize();i++){
                    previous.getCE(i).setHealth(previous.getCEHealth(i));   

                }
            }
            System.out.println(wiz.getName() + "casts a spell to turn back time");
            continue;

        }

        if (action.equals("RETREAT")){
            System.out.println(wiz.getName() + "runs away, and lives to fight another day");
            return; // gets out of the loop
        }

        if (!drag.hasLost()){
            String results = drag.takeTurn(wiz);
            System.out.println("Win" + results );


        }

        if (wiz.hasLost()) {
            System.out.println("Defeat");
         } 
         else {
             System.out.println("Victory");
         }

         








    
        


    }
        

}



}
