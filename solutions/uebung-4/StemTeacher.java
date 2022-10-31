/**
 * Diese Klasse stellt eine Lehrperson im MINT-Bereich (STEM auf Englisch) dar.
 * Sie erbt direkt von der Teacher Klasse. Eine Instanz der Klasse hat eine
 * Ganzzahl `numberOfCalculations` von elementaren Berechnungen, welche diese
 * Lehrperson pro Minute schafft.
 * 
 * Der Konstruktor soll den Namen und die Anzahl Berechnungen übernehmen.
 * Daneben soll es für `numberOfCalculations` einen trivialen Getter und
 * eine Methode `practiceCalculation` geben, welche zur Folge hat, dass
 * die Anzahl Berechnungen pro Minute um eins steigt.
 */

public class StemTeacher extends Teacher {
    private int numberOfCalculations; // Anzahl elementare Berechnungen pro Minute

    public StemTeacher(String name, int numberOfCalculations) {
        super(name);
        this.numberOfCalculations = numberOfCalculations;
    }

    public int getNumberOfCalculations() {
        return this.numberOfCalculations;
    }

    public void practiceCalculation() {
        this.numberOfCalculations += 1;
    }
}
