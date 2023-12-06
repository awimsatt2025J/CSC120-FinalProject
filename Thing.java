abstract class Thing {

    private String name;
    private String description;
    

    int x, y;

    public void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public String toString() {
        return this.getClass().getCanonicalName() + " at (" + this.x + "," + this.y + ")";
    }

    // Interface-y contract part
    abstract void grab();
    abstract void examine();

}
