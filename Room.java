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

    public boolean isComplete(Game g) {
        for(String object: this.neededObjects) {
            if(!this.currentObjects.contains(object)){
                System.out.println("Sorry, this room is not complete!"); //only prints out the first missing object, and do we want to tell them exactly what is missing or just that it is incorrect?
                return false;
            }
        } 
        g.countCompletedRooms();
        return true;
    }


    public String toString() {
        String currentContents = "";
        for(String o : this.currentObjects) {
            currentContents += o + ", ";
        }

        String fullDescription = this.name + " which is the " + this.description + " there is: " + currentContents + "in this room.";
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
    //     ArrayList<String> have = new ArrayList<String>();
    //     have.add("one");
    //     have.add("two");
    //     have.add("three");

    //    ArrayList<String> need = new ArrayList<String>();
    //    need.add("four");
    //    need.add("five");
    //    need.add("six");

    //     Room csRoom = new Room("CS room", "This room is where all the computer science objects should be.", have, need);
    //     System.out.println(csRoom);
    //     System.out.println(csRoom.isComplete());

    //     csRoom.pickUp("one");

    //     System.out.println(csRoom);

        // have.addAll(need);
        // System.out.println(csRoom.isComplete());
        // System.out.println(need);
        // System.out.println(have);

        // System.out.println(csRoom.neededObjects);

    }
}

