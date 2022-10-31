/**
 * Diese Klasse steht für eine Sprachlehrperson.
 * Sie erbt direkt von der Teacher Klasse und verfügt über
 * eine ganzzahlige Instanzvariable `vocabularySize`.
 * 
 * Der Konstruktor soll Namen und Vokabulargrösse übernehmen.
 * 
 * Für `vocabularySize` soll es zwei Methoden geben:
 * - `learnsNewWord()` soll die Vokabulargrösse um eines erhöhen
 * - `fogetsWord()` soll die Vokabulargrösse um eines senken,
 * sofern die Vokabulargrösse damit nicht negativ wird. Sonst soll
 * eine Warnung auf der Konsole ausgegeben werden.
 */

public class LanguageTeacher extends Teacher {
    int vocabularySize;

    public LanguageTeacher(String name, int vocabularySize) {
        super(name);
        this.vocabularySize = vocabularySize;
    }

    public void learnsNewWord() {
        vocabularySize++;
    }

    public void forgetsWord() {
        if (vocabularySize <= 0) {
            System.out.println("Man kann nichts vergessen, was man nicht weiss!");
        } else {
            vocabularySize--;
        }
    }
}
