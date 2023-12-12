import java.util.ArrayList;

public class Room {
    /* Class attributes */
    private String name; //the name of the room
    private String description; //the short description of the room
    ArrayList<String> currentObjects; //arraylist of things that are currently in the room
    private final ArrayList<String> neededObjects;  //arraylist of things that need to be in the room


    /*Constructor */
    public Room(String aName, String aDescription, ArrayList<String>current, ArrayList<String>needed) {
        this.name = aName;
        this.description = aDescription;
        this.currentObjects = current;
        this.neededObjects = needed;
    }

    /**
     * Checks if the room is complete (which means that currentObjects == neededObjects)
     * @param g - a game/the game you are playing
     * @return T/F: Is this room complete?
     */
    public boolean isComplete(Game g) {
        for(String object: this.neededObjects) {
            if(!this.currentObjects.contains(object)){
                System.out.println("Sorry, this room is not complete!"); //only prints out the first missing object, and do we want to tell them exactly what is missing or just that it is incorrect?
                return false;
            }
        } 
        g.countCompletedRooms();
        System.out.println("This room is complete!");
        return true;
    }

    /**
     * Prints the full description of the room for the user - its name, description, and what things currently contains
     */
    public String toString() {
        String currentContents = "";
        for(String o : this.currentObjects) {
            currentContents += o + ", ";
        }

        String fullDescription = this.name + " which is the " + this.description + " there is: " + currentContents + "in this room.";
        return fullDescription;

    }

    public String getName() {
        return this.name;
    }

    /**
     * Removes a thing that you would like to "pick up" from the currentObjects arraylist of a particular room
     * @param obj - the object you would like to pick up
     * @return - obj; the object you have successfully picked up, or a RuntimeException if you cannot pick up what you want to pick up (the room doesn't have it)
     */
    public String pickUp(String obj) {
        if(!this.currentObjects.contains(obj)){ //check to make sure obj is in current objects
            throw new RuntimeException(obj + " is not contained in this room.");
    
        }
        this.currentObjects.remove(obj);
        return obj;

    }

    /**
     * Adds a thing you would like to "put down" to the currentObjects arraylist of a particular room
     * @param obj - the object you would like to put down
     */
    public void putDown(String obj) {
        this.currentObjects.add(obj);
    }

    public static void main(String[] args) {


    }
}

