import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import java.util.Hashtable;

public class Game {
        boolean gameOver;
        private Hashtable <String, Room> gameMap;
        private Room currentLocation;
        private int nRoomsComplete;
        private ArrayList <String> inventory;

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
            Room csRoom = new Room("Ford 241", "the computer science classroom", csRoomhave, csRoomneed);
            gameMap.put("Ford 241", csRoom);
            ArrayList<String> chemRoomhave = new ArrayList<String>();
                chemRoomhave.add("apple");
                chemRoomhave.add("orange");
                chemRoomhave.add("cherry");
            ArrayList<String> chemRoomneed = new ArrayList<String>();
                chemRoomneed.add("cucumber");
                chemRoomneed.add("lettuce");
                chemRoomneed.add("carrot");
            Room chemRoom = new Room("Ford 223", "the chemistry lab", chemRoomhave, chemRoomneed);
            gameMap.put("Ford 223", chemRoom);
            this.currentLocation = csRoom;
            // gameMap.add(new Room("Ford 300", "The computer science classroom", csRoomhave, csRoomneed));
            this.gameOver = false;
            this.nRoomsComplete = 0;
            this.inventory = new ArrayList<String> ();
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

        public void countCompletedRooms(){
            this.nRoomsComplete ++;
        }
    
        public static void main(String[] args) {
            Game g = new Game();
            //Welcome, etc.
            System.out.println("Game Intro! Complete the Ford Hall Connections! Fill each classroom with the correct inventory. The methods you can use are: grab, drop, go, and check");

            while(!g.gameOver) {
                System.out.println("You are currently in " + g.currentLocation);
                String[] splitResponse = g.userInput();
                String wordOne = splitResponse[0];
                String wordTwo = splitResponse[1];
                try {
                    switch(wordOne){
                        case "grab":
                            try {
                                g.currentLocation.pickUp(wordTwo);
                                System.out.println("grabbing " + wordTwo);
                                g.inventory.add(wordTwo);
                            } catch (RuntimeException e) { 
                                System.out.println(e);
                            }
                            break;
                        case "drop":
                            if (g.inventory.contains(wordTwo)) {
                                g.currentLocation.putDown(wordTwo);
                                System.out.println("dropping " + wordTwo);
                                g.inventory.remove(wordTwo);
                            } else {
                                System.out.println( wordTwo + " is not in your inventory. Please try again.");
                            }
                             
                            break;
                        case "go":
                            if (g.gameMap.containsKey(wordTwo)) {
                                System.out.println("going to " + wordTwo);
                                g.currentLocation = g.gameMap.get(wordTwo);   
                            } else {
                                System.out.println("That room does not exist. Try again.");
                            }
                        case "check":
                            if (g.gameMap.containsKey(wordTwo)) {
                            System.out.println("checking " + wordTwo);
                                g.gameMap.get(wordTwo).isComplete(g);
                                if (g.nRoomsComplete == 4) {
                                    System.out.println("Congrats, you win!");
                                    g.gameOver = true;
                                }                                
                            } else {
                                System.out.println("That room does not exist. Try again.");
                            }

                        default:
                            throw new RuntimeException("Invalid command. Try again.");
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
