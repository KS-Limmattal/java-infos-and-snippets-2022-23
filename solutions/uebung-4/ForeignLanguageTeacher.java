/**
 * Diese Klasse steht für eine Fremdsprachlehrperson.
 * Sie erbt von der Klasse `LanguageTeacher` und
 * verfügt über eine Instanzvariable `translationSpeed`
 * von Typ float.
 * 
 * Der Konstruktor soll Namen, Vokabulargrösse und Übersetzungsgeschwindigkeit
 * übernehmen. Es soll zudem zwei Methoden geben:
 * - `practice()`, durch welche die Übersetzungsgeschwindigkeit um 1% erhöht
 * wird
 * - `getTimeToTranslateVocabulary()`, welche die Dauer (in Minuten) berechnet,
 * um das ganze Vokabular dieser Sprachlehrperson zu übersetzen.
 */

public class ForeignLanguageTeacher extends LanguageTeacher {
    private float translationSpeed; // Worte pro Minute

    public ForeignLanguageTeacher(String name, int vocabularySize, float translationSpeed) {
        super(name, vocabularySize);
        this.translationSpeed = translationSpeed;
    }

    public void practice() {
        this.translationSpeed *= 1.01;
    }

    public float getTimeToTranslateVocabulary() { // in Minuten
        return (float) this.vocabularySize / this.translationSpeed;
    }
}
