import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameInput {
    
    private ArrayList <Room> gameMap; //makes an array list of the rooms
    private Person player; //the user

    List<String> commandWords = new ArrayList<>(Arrays.asList("go", "examine", "give", "grab", "use")); //as list of commands the user is allowed to use
    List<String> things = new ArrayList<>(Arrays.asList("coffee", "Jordan's OneCard", "phone")); //a list of objects in the game

    public GameInput() {
        gameMap = new ArrayList <Room> ();
        gameMap.add(new Room("Ford 241", "CSC 120 Classroom"));

        player = new Person("Player", gameMap.get(0));
    }

    private ArrayList getMap() {
        return gameMap;
    }

    public String userInput(List<String> userInput){
        Scanner user_input = new Scanner(System.in);
        String output = "";

        return output;
    
    }





}
