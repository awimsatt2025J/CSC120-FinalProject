public class Coffee extends Thing {

    double caffeineLevel = 100.00;

    public Coffee(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void grab() {
        System.out.println( "The coffee is now in your hands.");
    }

    public void examine() {
        System.out.println("This is a steaming pepermint mocha with " + this.caffeineLevel + " grams of caffeine.");
    }

}
