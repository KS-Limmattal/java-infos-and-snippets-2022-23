/**
 * Diese Klasse steht für eine Lehrperson der Heimatsprache (Deutsch in unserem
 * Fall)
 * Sie erbt von der Klasse `LanguageTeacher` und verfügt über eine
 * Instanzvariable
 * `knowsForeignLanguage` als Wahrheitswert.
 * 
 * Der Konstruktor soll den Namen, die Vokabulargrösse und die Eigenschaft,
 * Fremdsprachen zu kennen übernehmen.
 * 
 * Für die Instanzvariable `knowsForeignLanguage` soll es einen trivialen Getter
 * geben,
 * sowie eine Methode `learnsForeignLanguage`, welche den Wert der Variable auf
 * Wahr setzt.
 */

public class NativeLanguageTeacher extends LanguageTeacher {
    private boolean knowsForeignLanguage;

    public NativeLanguageTeacher(String name, int vocabularySize, boolean knowsForeignLanguage) {
        super(name, vocabularySize);
        this.knowsForeignLanguage = knowsForeignLanguage;
    }

    public void learnsForeignLanguage() {
        this.knowsForeignLanguage = true;
    }

    public boolean knowsForeignLanguage() {
        return this.knowsForeignLanguage;
    }
}
