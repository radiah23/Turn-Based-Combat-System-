import java.util.ArrayList;

public class GameStack{
    private ArrayList<GameState> history;

    public GameStack(){
        history = new ArrayList<>();

    }
    public void push(GameState t){
        history.add(t);

    }

    public GameState pop(){
        if (history.isEmpty()){
            return null;
        }
        return history.remove(history.size()-1);//to return the last one

    }

    public GameState peek(){
        if (history.isEmpty()){
            return null;
        }
        return history.get(history.size()-1);//to return the last one

    }

    public boolean isEmpty(){
        return history.isEmpty();


    }

        

    }



    





