import java.util.ArrayList;

public class Inventory {
    private ArrayList<Thing> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void add(Thing o) {
        this.items.add(o);
    }

    public void drop(Thing o) {
        if (!this.items.contains(o)) {
            throw new RuntimeException("Sorry, " + o + " is not in your inventory.");
        }
        this.items.remove(o);
    }

    public String toString() {
        String contents = "";
        for (Thing o : this.items) {
            contents += " - " + o.toString() + "\n";
        }
        return contents;
    }

    public static void main(String[] args) {
        Inventory myStuff = new Inventory();
        System.out.println(myStuff);
        Coffee myCoffee = new Coffee(0, 0);
        myStuff.add(myCoffee);
        System.out.println(myStuff);

        for (Thing o : myStuff.items) {
            o.examine();
        }
    }

}
