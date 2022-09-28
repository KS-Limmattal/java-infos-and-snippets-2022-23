import java.util.Scanner; // Für Benutzereingaben

public class Loops {
    /*
     * Snippet zu Schleifen
     */
    public static void main(String[] args) {

        // Einfache for-Schleife
        for (int i = 0; i < 10; i++) {
            System.out.println("Wert der Zählervariablen: " + i);
        }

        // Erweiterte for-Schleife (forEach-Schleife) für Arrays und Sammlungen
        String[] hundenamen = { "Fido", "Bello", "Lassie", "Rocky" };
        for (String hund : hundenamen) {
            System.out.println(hund);
        }

        // Ausstieg mittels "break", Überspringen mittels "continue"
        String[] anweisungen = { "Lese", "Schreibe", "Überspringe", "Turne", "Singe", "Brich ab", "Zu spät" };
        for (String anweisung : anweisungen) {
            if (anweisung.equals("Überspringe")) {
                continue;
            }
            if (anweisung.equals("Brich ab")) {
                break;
            }
            System.out.println(anweisung);
        }

        // while-Schleife 1

        String s = "Eine Zeichenkette bestehend aus 7 Wörter und 2 Zahlen";
        Scanner strScan = new Scanner(s); // Zum Einlesen der Zeichenkette s

        while (strScan.hasNext()) {

            if (strScan.hasNextInt()) {
                System.out.println("Nächster ganzzahliger Wert: " + strScan.nextInt());
            } else {
                System.out.println("Kein ganzzahliger Wert: " + strScan.next());
            }
        }
        strScan.close();

        // while-Schleife 2

        Scanner scanner = new Scanner(System.in); // zum Einlesen von Benutzer-Eingaben

        System.out.println("Geben Sie eine Zahl ein: ");
        int x = scanner.nextInt();
        while (x > 1) {
            if (x % 2 == 0) {
                x = x / 2;
            } else {
                x = 3 * x + 1;
            }
            System.out.println(x);
        }

        // do-while Schleife, wird mindestens einmal ausgeführt

        scanner.nextLine();
        String input;
        do {
            System.out.println("Möchten Sie noch was sagen? Sagen Sie 'Ende', um abzubrechen");
            input = scanner.nextLine();
            System.out.println("Sie haben '" + input + "' gesagt");
        } while (!input.equals("Ende"));

        scanner.close();
    }
}
