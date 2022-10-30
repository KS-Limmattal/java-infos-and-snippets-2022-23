public class Vehicle {
    private long speed; // in Kilometer per Stunde; wird nur in der Klasse Vehicle gesehen
    protected String name; // wird in Vehicle und allen abgeleiteten Klassen (Car, SportsCar, Bike) gesehen

    public static final long SPEED_OF_LIGHT = 299792458L * 36 / 10; // meters per second in kilometres per hour

    public Vehicle(long speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    public long getSpeed() {
        return this.speed;
    }

    public void increaseSpeed() {
        if (this.speed < SPEED_OF_LIGHT) {
            this.speed += 1;
        } else {
            System.out.println("Schneller als Lichtgeschwindigkeit! Bitte informieren Sie umgehend Albert Einstein!!");
        }
    }

    public void decreaseSpeed() {
        if (this.speed > -SPEED_OF_LIGHT) {
            this.speed -= 1;
        } else {
            System.out.println("Auch das sollte nicht klappen!");
        }
    }

    public boolean advances() {
        return this.speed > 0;
    }

    public String toString() {
        return "Fahrzeug " + this.name + " mit aktueller Geschwindigkeit von " + this.speed + " km/h";
    }
}
