import java.util.ArrayList;
import java.util.Scanner;


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
                csRoomhave.add("oneCard");
                csRoomhave.add("concical");
                csRoomhave.add("compass");
                csRoomhave.add("pea plant");
            ArrayList<String> csRoomneed = new ArrayList<String>();
                csRoomneed.add("oneCard");
                csRoomneed.add("lazy dog");
                csRoomneed.add("train");
                csRoomneed.add("memory model");
            Room csRoom = new Room("Ford 241", "the computer science classroom", csRoomhave, csRoomneed);
            gameMap.put("Ford 241", csRoom);
            ArrayList<String> chemRoomhave = new ArrayList<String>();
                chemRoomhave.add("memory model");
                chemRoomhave.add("hammer");
                chemRoomhave.add("petri dish");
                chemRoomhave.add("worm");
            ArrayList<String> chemRoomneed = new ArrayList<String>();
                chemRoomneed.add("concical");
                chemRoomneed.add("volumetric");
                chemRoomneed.add("round-bottom");
                chemRoomneed.add("retort");
            Room chemRoom = new Room("Ford 100", "the chemistry lab", chemRoomhave, chemRoomneed);
            gameMap.put("Ford 100", chemRoom);
            ArrayList<String> bioRoomhave = new ArrayList<String>();
                bioRoomhave.add("volumetric");
                bioRoomhave.add("saw");
                bioRoomhave.add("retort");
                bioRoomhave.add("lazy dog");
            ArrayList<String> bioRoomneed = new ArrayList<String>();
                bioRoomneed.add("pea plant");
                bioRoomneed.add("worm");
                bioRoomneed.add("cell diagram");
                bioRoomneed.add("petri dish");
            Room bioRoom = new Room("Ford 300", "the biology classroom", bioRoomhave, bioRoomneed);
            gameMap.put("Ford 300", bioRoom);
            ArrayList<String> egRoomhave = new ArrayList<String>();
                egRoomhave.add("train");
                egRoomhave.add("cell diagram");
                egRoomhave.add("3d printer");
                egRoomhave.add("round-bottom");
            ArrayList<String> egRoomneed = new ArrayList<String>();
                egRoomneed.add("saw");
                egRoomneed.add("hammer");
                egRoomneed.add("compass");
                egRoomneed.add("3d printer");
            Room egRoom = new Room("Ford 000", "the engineering playground", egRoomhave, egRoomneed);
            gameMap.put("Ford 000", egRoom);
            this.currentLocation = csRoom;
            this.gameOver = false;
            this.nRoomsComplete = 0;
            this.inventory = new ArrayList<String> ();
            //other set-up
        }        


        public String[] userInput(){
            Scanner user_input = new Scanner(System.in);
            System.out.println("What would you like to do: ");
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
            System.out.println("Game Intro! Complete the Ford Hall Connections! Fill each classroom with the correct inventory. The methods you can use are: grab, drop, go, check, and help");
            System.out.println("The rooms are: Ford 000, Ford 100, Ford 241, Ford 300");

            while(!g.gameOver) {
                System.out.println("You are currently in " + g.currentLocation);
                String[] splitResponse = g.userInput();
                String wordOne = splitResponse[0]; 
                // if split repsonse length is 1, and word one is not help, throw error, otherwise proceed with code
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
                            break;
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
                            break;
                        case "help":
                            System.out.println("The commands you can use are: grab, go, drop, and check");
                            break;

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
