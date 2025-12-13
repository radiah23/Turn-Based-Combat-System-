public class GameState{
    protected CombatEntity[] beings;
    protected int[] beingsHealth;

    public GameState(CombatEntity[] b, int[] bHealth){
        beings = b;
        beingsHealth = bHealth;

    }
    public CombatEntity getCE(int index){
        return beings[index];
    }
    public int getCEHealth(int index){
        return beingsHealth[index];
    }
    public int sizeHealth(){
        return beingsHealth.length;
    }

    public int getSize(){
        return beings.length;
    }


    }









