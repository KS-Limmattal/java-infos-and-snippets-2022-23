public class Bike extends Vehicle {
    public boolean hasLamp;

    public Bike(long speed, String name, boolean hasLight) {
        super(speed, name);
        this.hasLamp = hasLight;
    }

    public void checkLight() {
        if (this.hasLamp) {
            System.out.println("Velolampe ist OK");
        } else {
            System.out.println("Bitte montieren Sie eine Lampe auf das Velo.");
        }
    }
}
