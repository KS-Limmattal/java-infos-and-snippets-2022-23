/*
 * Verwenden Sie die java.util.Scanner Klasse, um in der main-Methode eine Ganzzahl (int)
 * sowie eine beliebige Zeile einzulesen, nachdem Sie den Benutzer via Konsolen-Ausgabe
 * dazu auffordern.
 * Geben Sie darauf (ausser wenn eine der untenstehenden Ausnahmen eintritt)) die eingegebene 
 * Zeile zusammen mit einem Zähler so oft aus, wie die eingegebene Ganzzahl angibt.
 * 
 * Beispiel: eingegebene Ganzzahl 3, eingegebene Zeile "Hut ab!"
 * -> Ausgabe:
 * 1: Hut ab!
 * 2: Hut ab!
 * 3: Hut ab!
 * 
 * Ausnahmen:
 * Ist die Ganzzahl <= 0, so geben Sie stattdessen eine Fehlermeldung auf der Konsole aus.
 * Ist die Ganzzahl hingegen >0 und lautet die Zeile "quit", so geben Sie die Meldung "Ende" aus.
 */

import java.util.Scanner;

public class Aufgabe1 {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Geben Sie eine Anzahl Wiederholungen ein, n = ");
      int n = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Geben Sied die zu wiederholende Zeile ein! ");
      String s = scanner.nextLine();

      if (n <= 0) {
         System.out.println("Die Anzahl Wiederholungen muss positiv sein!");
      } else if (s.equals("quit")) {
         System.out.println("Ende");
      } else {
         for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + s);
         }
      }
      scanner.close();
   }
}
