/*
 * Die Klasse "SearchableString" soll die Interfaces Searchable und Addable auf Basis einer Zeichenkette implementieren
 * 
 * Sie enthält eine einzige Instanzvariable "str" von Typ "String".
 * 
 * Es soll ein Konstruktor geschrieben werden, der die Zeichenkette "str" übernimmt.
 * 
 * Die "search" und "countOccurences"-Methoden sollen die gesuchte Zeichenkette innerhalb des Strings str suchen. Tritt
 * eine Zeichenkette innerhalb von "str" mehrfach auf, so soll sie mehrfach gezählt werden. Z.B. enhält "ananas" die 
 * Zeichkette "ana" zweimal (einmal von 1.-3. Position und einmal von 3.-5. Position)
 * 
 * Die Methode "add" soll die Zeichenkette an "str" anhängen (Bsp. "haus" an "Baum" angehängt ergibt "Baumhaus")
 * */

 public class SearchableString implements Searchable, Addable {
    String str;

    public SearchableString(String str) {
        this.str = str;
    }

    @Override
    public boolean search(String searchString) {
        int n = searchString.length();
        int m = this.str.length();
        if (m < n) {
            return false;
        }
        for (int i = 0; i <= m - n; i++) { // i: Position, an welcher searchString gesucht wird
            if (this.str.substring(i, i + n).equals(searchString)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int countOccurences(String searchString) {
        int n = searchString.length();
        int m = this.str.length();
        int count = 0;
        if (m < n) {
            return 0;
        }
        for (int i = 0; i <= m - n; i++) { // i: Position, an welcher searchString gesucht wird
            if (this.str.substring(i, i + n).equals(searchString)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void add(String string) {
        this.str = this.str + string;
    }

}
