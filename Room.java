import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    ArrayList<String> currentObjects; //arraylist of things that are currently in the room
    private final ArrayList<String> neededObjects;  //arraylist of things that need to be in the room


    public Room(String aName, String aDescription, ArrayList<String>current, ArrayList<String>needed) {
        // constructor
        this.name = aName;
        this.description = aDescription;
        this.currentObjects = current;
        this.neededObjects = needed;
    }

    public boolean isComplete() {
        for(String object: this.neededObjects) {
            if(!this.currentObjects.contains(object)){
                System.out.println("missing: " + object);
                return false;
            }
        }
        return true;
    }


    public String toString() {
        String currentContents = "";
        for(String o : this.currentObjects) {
            currentContents += o + ", ";
        }

        String fullDescription = "The name of this room is " + this.name + " and the description is the following: " + this.description + " The current inventory of this room is: " + currentContents;
        return fullDescription;

    }

    public String pickUp(String obj) {
        //check to make sure in current objects
        if(!this.currentObjects.contains(obj)){
            throw new RuntimeException(obj + " is not contained in this room.");
    
        }
        this.currentObjects.remove(obj);
        return obj;

    }

    public void putDown(String obj) {
        this.currentObjects.add(obj);
    }

    public static void main(String[] args) {
        ArrayList<String> have = new ArrayList<String>();
        have.add("one");
        have.add("two");
        have.add("three");

       ArrayList<String> need = new ArrayList<String>();
       need.add("four");
       need.add("five");
       need.add("six");

        Room csRoom = new Room("CS room", "This room is where all the computer science objects should be.", have, need);
        System.out.println(csRoom);
        System.out.println(csRoom.isComplete());

        have.addAll(need);
        System.out.println(csRoom.isComplete());
        System.out.println(need);
        System.out.println(have);

        System.out.println(csRoom.neededObjects);

    }
}

// each individual room is an extension of the room class