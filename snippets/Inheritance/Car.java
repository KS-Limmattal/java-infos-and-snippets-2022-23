public class Car extends Vehicle {
    private String manufacturer;

    public Car(long speed, String name, String manufacturer) {
        super(speed, name); // Rufe den Konstuktor der Basisklasse Vehicle auf
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer.equals("Tesla")) {
            this.manufacturer = "FreeBird";
            System.out.println("Hersteller " + manufacturer + " wurde unbenannt zu " + this.manufacturer);
        } else {
            this.manufacturer = manufacturer;
        }
    }

    public void printNameAndManufacturer() {
        // this.name hat Sichtbarkeit protected in Vehicle, kann also auch in der
        // abgeleiteten Klasse Car verwendet werden
        System.out.println("Fahrzeug " + this.name + " mit Hersteller " + this.manufacturer);
    }

}
