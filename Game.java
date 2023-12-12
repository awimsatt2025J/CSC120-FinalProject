import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;


public class Game {
        /* Class attributes */
        boolean gameOver; //tells us if the game is completed or not
        private Hashtable <String, Room> gameMap; //collects all the rooms into one Hashtable
        private Room currentLocation; //the location the user is currently un
        private int nRoomsComplete; //the number of rooms that the user has completed (gotten currentObjects to equal neededObjects)
        private ArrayList <String> inventory; //includes the things that the user currently possesses

        /* Constructor */
        public Game() {
            this.gameMap = new Hashtable <String, Room> ();
            ArrayList<String> csRoomhave = new ArrayList<String>(); //creates arraylist of current things in the CS room
                csRoomhave.add("oneCard"); //adding things to the arraylist of current things in the CS room
                csRoomhave.add("concical");
                csRoomhave.add("compass");
                csRoomhave.add("pea plant");
            ArrayList<String> csRoomneed = new ArrayList<String>(); //creates arraylist of needed things for the CS room
                csRoomneed.add("oneCard"); //adding things to the arraylist of needed things for the CS room
                csRoomneed.add("lazy dog");
                csRoomneed.add("train");
                csRoomneed.add("memory model");
            Room csRoom = new Room("Ford 241", "the computer science classroom", csRoomhave, csRoomneed); //creates a new room for computer science
            gameMap.put("ford 241", csRoom); //adds the CS room to the gameMap hashtable
            ArrayList<String> chemRoomhave = new ArrayList<String>(); //creates arraylist of current things in the chem room
                chemRoomhave.add("memory model"); //adding things to the current things in the chem room
                chemRoomhave.add("hammer");
                chemRoomhave.add("petri dish");
                chemRoomhave.add("worm");
            ArrayList<String> chemRoomneed = new ArrayList<String>(); //creates arraylist of needed things in the chem room
                chemRoomneed.add("concical"); //adding things to the arraylist of needed things for the chem room
                chemRoomneed.add("volumetric");
                chemRoomneed.add("round-bottom");
                chemRoomneed.add("retort");
            Room chemRoom = new Room("Ford 100", "the chemistry lab", chemRoomhave, chemRoomneed); //creates a new room for chemistry
            gameMap.put("ford 100", chemRoom); //adds the chem room to the gameMap hashtable
            ArrayList<String> bioRoomhave = new ArrayList<String>(); //creates rraylist of current things in the bio room
                bioRoomhave.add("volumetric"); //adding things to the arraylist of current things in the bio room
                bioRoomhave.add("saw");
                bioRoomhave.add("retort");
                bioRoomhave.add("lazy dog");
            ArrayList<String> bioRoomneed = new ArrayList<String>(); //creates arraylist of needed things for the bio room
                bioRoomneed.add("pea plant"); //adding things to the arraylist of needed things for the bio room
                bioRoomneed.add("worm");
                bioRoomneed.add("cell diagram");
                bioRoomneed.add("petri dish");
            Room bioRoom = new Room("Ford 300", "the biology classroom", bioRoomhave, bioRoomneed); //creates a new room for biology
            gameMap.put("ford 300", bioRoom); //adds the bio room to the gameMap hashtable
            ArrayList<String> egRoomhave = new ArrayList<String>(); //creates arraylist of current things in the engineering room
                egRoomhave.add("train"); //adding things to the arraylist of current things in the engineering room
                egRoomhave.add("cell diagram");
                egRoomhave.add("3d printer");
                egRoomhave.add("round-bottom");
            ArrayList<String> egRoomneed = new ArrayList<String>(); //creates arraylist of needed things for the engineering room
                egRoomneed.add("saw"); //adding things to the arraylist of needed things for the engineering room
                egRoomneed.add("hammer");
                egRoomneed.add("compass");
                egRoomneed.add("3d printer");
            Room egRoom = new Room("Ford 000", "the engineering playground", egRoomhave, egRoomneed); //creates a new room for engineering
            gameMap.put("ford 000", egRoom); //adds the engineering room to the gameMap hashtable
            this.currentLocation = csRoom; //starts the user in the computer science room
            this.gameOver = false; //initializes the game as not gameOver to start
            this.nRoomsComplete = 0; //initializes the number of rooms completed by the user to 0
            this.inventory = new ArrayList<String> (); //initializes the user's inventory to be empty
        }        

        /**
         * Receives/processes what the user inputs what they would like to do
         * @return splitResponse - an array of strings that the user inputed, that is split between their first word and their second word (puts the first string into the 0 index of the array and the second one into the 1 index of the array)
         */
        public String[] userInput(){
            Scanner user_input = new Scanner(System.in);
            System.out.println("What would you like to do? ");
            String response = user_input.nextLine().toLowerCase();
            String[] splitResponse = response.split(" ", 2);
            
            return splitResponse;
            
        }

        /**
         * Counts the number of rooms that the user has completed (the # of rooms they have gotten the current objects to equal the needed objects)
         */
        public void countCompletedRooms(){
            this.nRoomsComplete ++;
        }

        public void displayInventory(){
            System.out.println("Your inventory is: " + this.inventory);
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
                if (splitResponse.length == 1){
                    switch(wordOne){
                        case "help":
                            System.out.println("The commands you can use are: grab, go, drop, and check. The rooms are Ford 000, Ford 100, Ford 241, and Ford 300.");
                            break;  
                        default:
                            System.out.println("Invalid command. Try again");
                    }
                }
                else {
                    //if split repsonse length is 1, and word one is not help, throw error, otherwise proceed with code
                    String wordTwo = splitResponse[1];
                    try {
                        switch(wordOne){
                            case "view":
                                if (wordTwo.equals("inventory")) {
                                    g.displayInventory();
                                } else {
                                    System.out.println("You are only allowed to view your inventory.");
                                }
                                break;
                                
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
                                    g.currentLocation = g.gameMap.get(wordTwo);
                                    System.out.println("going to " + g.currentLocation.getName());
                                    
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


                            default:
                                throw new RuntimeException("Invalid command. Try again.");
                        }
                    } catch (RuntimeException e) { 
                        System.out.println(e);
                    } 
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
            
        }
}
