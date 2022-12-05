/*
 * Schreiben Sie ein enum "Action" mit den Werten TRIPLE, INVERT, NORMALIZE, sowie PRINT 
 * 
 * Schreiben Sie eine Klasse "Vector2d" mit Instanzvariablen "x" und "y" (von Typ double)
 * und Klassenvariable "numVectorsContructed", welche die Anzahl konstruierter Vektoren zählt
 * 
 * einen Konstruktor, welcher die Werte von "x" und "y" übernimmt und den Zähler aktualisiert
 * 
 * eine Methode "toString" mit Rückgabewert von Typ String, welche den Vektor als Zeichenkette
 * wie "Vektor (2.3, 1.4)" zurückgibt
 * 
 * eine Methode "runAction" mit Parameter von Typ "Action", welche mit Hilfe eines switch-Statements
 * - im Falle des enum-Werts "TRIPLE" die Komponenten "x" und "y" verdreifacht
 * - im Falle des enum-Werts "INVERT" den Vektor durch den Gegenvektor (mit Komponenten -x und -y) ersetzt
 * - im Falle des enum-Werts "NORMALIZE" soll der Vektor (bzw. seine Komponenten x und y) durch seinen 
 *   Betrag (Wurzel aus x*x+y*y) geteilt werden
 * - im Falle des enum-Werts "PRINT" den Vektor auf der Konsole ausgibt
 * 
 * eine statische Methode "printVectorsConstructed", welche auf die Konsole schreibt, wieviele Vektoren
 * bisher konstruiert wurden.
 * 
 * In der main-Methode von Aufgabe3.java soll der Vektor (2,5) instanziert werden und danach in einer
 * Schleife die "runAction"-Methode nacheinander auf diesen Vektor angewendet werden
 * 
 */

public class Aufgabe3 {
   public static void main(String[] args) {
      Vector2d v = new Vector2d(2, 5);
      for (Action a : Action.values()) {
         v.runAction(a);
      }
      // Vector2d.printVectorsConstructed();
   }
}