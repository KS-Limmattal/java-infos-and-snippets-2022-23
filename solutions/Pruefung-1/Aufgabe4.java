/* 
 * Schreiben Sie eine Klasse "Building" mit davon abgeleiteten Klassen "House" und "School". Achten Sie dabei
 * darauf, dass die Instanzvariablen die minimale Sichtbarkeit (private < protected < public) haben unter 
 * der Bedingung, dass der Code kompiliert
 * 
 * Die Klasse "Building" repräsentiert ein Gebäude. Jedes Gebäude hat
 * - eine Höhe "height" (vom Typ double, in Metern gemessen)
 * - ein Baujahr "year" (vom Typ int)
 *   
 * einen trivialen Getter für "height"
 * 
 * einen Setter für "height", welche die Höhe auf den entsprechenden Parameter setzt, falls dieser >= 0 ist, 
 *   und sonst eine Warnung ausgibt und die Höhe auf 0 setzt

 * eine Methode "toString" mit Rückgabewert von Typ String, welche das Gebäude durch eine Zeichenkette 
 *     wie "Gebäude der Höhe 7.3 m von Baujahr 1993" repräsentiert
 * 
 * sowie  einen Konstruktor, welche "year" übernimmt und für "height" den Setter benutzt.
 * 
 * 
 * Die Klasse "House" repräsentiert ein Gebäude, in welchem Leute wohnen. Jedes Haus hat
 * - eine Anzahl Bewohner "numInhabitants" (von Typ int)
 * - eine Anzahl Schlafzimmer "numBedrooms" (von Typ int)
 * 
 * einen Konstruktor, welcher "height", "year", "numInhabitants" und "numBedrooms" übernimmt
 * und dabei den Konstruktor der Basisklasse einsetzt
 * 
 * eine Methode "inhabitantsPerBedroom", welche die durchschnittliche Anzahl Bewohner pro Schlafzimmer zurückgibt
 * 
 * 
 * Die Klasse "School" repräsentiert ein Gebäude, in welchem Unterricht stattfindet. 
 * Jede Schule hat
 * - ein Schuljahr "schoolYear" (von Typ int)
 * 
 * einen Konstruktor, welcher "height", "year", sowie "schoolYear" übernimmt
 * und dabei den Konstruktor der Basisklasse einsetzt
 * 
 * eine Methode "yearsSinceStart", welche die Anzahl vergangener Jahre seit dem Baujahr zurückgibt
 * 
 * 
 * Die main-Methode in Aufgabe4.java soll je eine Instanz der Klassen "Building", "House" und "School" instanzieren
 * und in einem Array erfassen. Das Array-Element, welches der Instanz von "School" entspricht, soll in eine (neue)
 * Instanz der Klasse "School" gecastet werden und die "yearsSinceStart"-Methode soll mit dieser neuen Instanz
 * aufgerufen werden
 * 
*/

public class Aufgabe4 {
    public static void main(String[] args) {
        Building[] buildings = { new Building(25, 1983), new House(8, 1995, 5, 3), new School(25, 1975, 2022) };
        // for (Building b : buildings) {
        // System.out.println(b);
        // }
        School school = (School) buildings[2];
        // int n =
        school.yearsSinceStart();
        // System.out.println(n);
    }
}