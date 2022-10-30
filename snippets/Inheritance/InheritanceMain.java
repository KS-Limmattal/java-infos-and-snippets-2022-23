public class InheritanceMain {
    public static void main(String[] args) {

        // Instanzierung
        Vehicle soapBox = new Vehicle(20, "Meine Seifenkiste");
        Car car = new Car(90, "Leos Firmenwagen", "Audi");
        Bike crossbike = new Bike(24, "Mein Cross-Bike", true);
        SportsCar italianCar = new SportsCar(250, "Krasses Sportauto", "Lamborghini", 5);

        // Schreibe erzeugte Fahrzeuge in ein Array von Typ Vehicle[]
        Vehicle[] vehicles = { soapBox, car, crossbike, italianCar }; // implizites Casting (von abgeleiteter Klasse zu
                                                                      // Basisklasse)
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            if (vehicle.getSpeed() > 80) {
                System.out.println("Dieses Fahrzeug ist ziemlich schnell unterwegs");
            }
        }

        // 2x wird versucht, die Lichtgeschwindigkeit zu übertreten
        for (long i = 0; i < Vehicle.SPEED_OF_LIGHT - 248; i++) {
            italianCar.increaseSpeed();
        }
        italianCar.printNameAndManufacturer();

        // Bremse das Velo ab, solange es positive Geschwindigkeit hat
        while (crossbike.advances()) {
            crossbike.decreaseSpeed();
        }
        System.out.println(crossbike);

        crossbike.hasLamp = false; // Variable mit Sichtbarkeit public
        crossbike.checkLight();
        crossbike.hasLamp = true;

        // Wenn man crossbike vergisst und stattdessen mit vehicles[2] arbeitet:
        Bike bike2 = (Bike) vehicles[2]; // Casting von Basisklasse zu Superklasse (muss explizit gemacht werden)
        bike2.checkLight(); // vehicles[2].checkLight(); ginge hingegen nicht, da nur Bike die Methode
                            // checkLight hat, nicht Vehicle

        Car car2 = (Car) vehicles[1]; // Hingegen könnte z.B. vehicles[2] nicht zum Typ Car gecastet werden, sondern
                                      // nur zu Typ Bike, und vehicles[0] könnte weder zum Typ Car noch zum Typ Bike
                                      // gecastet werden;
        // Car c = (Car) vehicles[2]; // gäbe einen Laufzeit-Fehler
        System.out.println("Sind die beiden Autos identisch? " + ((car == car2) ? "Ja" : "Nein")); // Antort lautet "Ja"
        car2.setManufacturer("Tesla"); // Es ginge nicht vehicles[0].setManufacturer("Tesla");

        System.out.println(italianCar + " hat " + italianCar.getRacesWon() + " Rennen gewonnen. ");
        // Gewinne 6 Rennen dazu
        for (int i = 0; i < 6; i++) {
            italianCar.registerRaceWon();
        }
        System.out.println(italianCar + " hat " + italianCar.getRacesWon() + " Rennen gewonnen. ");
    }
}
