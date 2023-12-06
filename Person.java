public class Person {
    String name;
    private Room location;

    public Person(String aName, Room aRoom) {
        location = aRoom;
    }

    public void setLocation(Room aRoom) {
        location = aRoom;
    }

    public Room personLocation() {
        return location;
    }


}
