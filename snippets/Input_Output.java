import java.util.Scanner; // Für Benutzereingaben

public class Input_Output {
    public static void main(String[] args) {
        // Output
        System.out.println("Diese Zeile wird auf die Konsole geschrieben");
        System.out.print("Dies wird auf die Konsole ohne Zeilenumbruch am Ende geschrieben");
        System.out.println(); // Leere Zeile
        System.out.println(15); // Schreibe eine Zahl (int) auf die Konsole (mit Zeilenumbruch)

        // Input
        Scanner scanner = new Scanner(System.in); // zum Einlesen von Benutzer-Eingaben von der Konsole
                                                  // benötigt java.util.Scanner

        System.out.println("Geben Sie eine Zahl (int) ein: ");
        int x = scanner.nextInt();
        scanner.nextLine(); // konsumiert das <Enter> nach der Eingabe der Zahl

        System.out.println("Geben Sie drei Zahlen (double) separiert durch Leerzeichen ein: ");
        double x1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double x3 = scanner.nextDouble();
        scanner.nextLine(); // konsumiert das <Enter> nach der Eingabe der Zahlen

        System.out.println("Geben Sie eine beliebige Zeile ein: ");
        String s = scanner.nextLine();

        System.out.println("Sie haben eingegeben: int: " + x + ", double 1: " + x1 + ", double 2: " + x2
                + ", double 3: " + x3 + ", Zeile: " + s);

        scanner.close(); // Es wird empfohlen, einen Scanner zu schliessen, wenn er nicht mehr gebraucht
                         // wird.
    }
}