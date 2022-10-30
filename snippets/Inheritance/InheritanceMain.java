/**
 * Grundsätzlich gibt es zwei Möglichkeiten, die Variablen und Methoden einer
 * Klasse A innerhalb einer anderen Klasse B zu verwenden.
 * 
 * - Die eine Möglichkeit kennen wir schon: Wir erzeugen eine Instanz von Klasse
 * A in Klasse B und verwenden die Variablen und Methoden dieser Instanz.
 * Diese Instanz kann eine Instanzvariable der Klasse B sein.
 * Wir sagen in diesem Fall "Klasse B hat ein Objekt von Klasse A" und sprechen
 * von "Aggregation"
 * 
 * - Die andere Möglichkeit besteht in der sogenannten "Vererbung".
 * Mittels "public class B extends A" erbt Klasse B alle Variablen und Methoden
 * von Klasse A. Weitere Variablen und Methoden können hinzugefügt werden.
 * Der Konstruktor von Klasse b ruft den Konstruktor von Klasse A mit Hilfe
 * der super()-Methode auf. Dieser werden alle Parameter übergeben, welche
 * der Konstruktor der Klasse A braucht.
 * wir sagen "Klasse B erbt von Klasse A"
 * 
 * Vererbung sollte eingesetzt werden, wenn ein Objekt der Klasse B auch ein
 * Objekt der Klasse A sein soll, einfach spezieller, mit mehr
 * Eigenschaften/Methoden
 * 
 * Aggregation sollten im Gegenzug verwendet werden, wenn eine Instanz von
 * Klasse A Teil von Klasse B sein soll.
 * 
 * Wenn Klasse B von Klasse A erbt, so nennen wir Klasse A "Basisklasse"
 * und Klasse B "abgeleitete Klasse"
 * 
 * Es ist auch möglich, dass etwa Klasse C von Klasse B erbt und Klasse B von
 * Klasse A. Dann erbt Klasse C also indirekt auch von A.
 * 
 * Was hingegen in Java nicht möglich ist, ist dass eine Klasse von mehreren
 * Klassen erbt. Es gibt dafür sogenannte "Interfaces", welche in engem
 * Zusammenhang zur Vererbung stehen. Eine Klasse kann mehrere Interfaces
 * implementieren. Um dies zu verstehen, werden wir später "Abstrakte Klassen"
 * und dann "Interfaces" studieren.
 * 
 * Im folgenden Beispiel ist "Vehicle" die Basisklasse mit den beiden
 * abgeleiteten Klassen "Car" und "Bike". Von "Car" ist desweiteren Klasse
 * "SportsCar" abgeleitet. Indirekt erbt also Klasse "SportsCar" auch von Klasse
 * "Vehicle"
 */

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
