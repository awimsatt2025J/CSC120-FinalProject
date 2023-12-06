
public class Room {
    private String name;
    private String description;

    public Room(String aName, String aDescription) {
        // constructor
        name = aName;
        description = aDescription;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

// each individual room is an extension of the room class