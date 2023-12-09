import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import java.util.Hashtable;

public class Game {
        boolean gameOver;
        private Hashtable <String, Room> gameMap; //makes an array list of the rooms
        private Room currentLocation;

        public Game() {
            this.gameMap = new Hashtable <String, Room> ();
            ArrayList<String> csRoomhave = new ArrayList<String>();
                csRoomhave.add("one");
                csRoomhave.add("two");
                csRoomhave.add("three");
            ArrayList<String> csRoomneed = new ArrayList<String>();
                csRoomneed.add("four");
                csRoomneed.add("five");
                csRoomneed.add("six");
            Room csRoom = new Room("Ford 300", "The computer science classroom", csRoomhave, csRoomneed);
            gameMap.put("Ford 300", csRoom);
            this.currentLocation = csRoom;
            // gameMap.add(new Room("Ford 300", "The computer science classroom", csRoomhave, csRoomneed));
            this.gameOver = false;
            //other set-up
        }

        


        public String[] userInput(){
            Scanner user_input = new Scanner(System.in);
            System.out.println("What would you like to do: ");
            //List<String> commandWords = new ArrayList<>(Arrays.asList("grab", "drop", "go")); //as list of commands the user is allowed to use
           // List<String> things = new ArrayList<>(Arrays.asList("one", "two", "three", "left", "right")); //a list of objects in the game
            String response = user_input.nextLine();
            String[] splitResponse = response.split(" ", 2);
            
            return splitResponse;
            
        }
    
        public static void main(String[] args) {
            Game g = new Game();
            //Welcome, etc.
            System.out.println("You woke up in the computer science classroom after falling asleep during class. You get up to leave and try to open the door, but it is locked. You are stuck in the classroom! ");


            while(!g.gameOver) {
                String[] splitResponse = g.userInput();
                String wordOne = splitResponse[0];
                String wordTwo = splitResponse[1];
                try {
                    switch(wordOne){
                        case "grab":
                            System.out.println("grabbing " + wordTwo);
                                g.currentLocation.pickUp(wordTwo);
                            break;
                        case "drop":
                            System.out.println("dropping " + wordTwo);
                                g.currentLocation.putDown(wordTwo);
                            break;
                        case "go":
                            System.out.println("going to " + wordTwo);
                            g.currentLocation = g.gameMap.get(wordTwo);
                        default:
                    }
                } catch (RuntimeException e) {
                    System.out.println(e);
                } 
            // for (int i = 0; i < splitResponse.length; i++) {
            //     System.out.println(splitResponse[i]);
            // }

                //get user input
                //try {
                //      string input = ___.nextLine();
                //      switch (input):
                //          case "pick up"{
                //              //ask for obj, room.pickUp(obj);
                //          }
                //          case "put down":
                //
                //          case "exit":
                //
                //} catch ()


                //respond
                //check for gameOver
            }
            //Goodbye
        }
}
