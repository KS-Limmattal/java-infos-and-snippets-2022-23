/*
 * Das Interface "Searchable" soll Methoden
 * 
 * - "search", welche eine zu suchende Zeichenkette als Parameter annimmt und Rückgabewert true/false hat,
 *   Dabei steht "true" für "vorhanden" und "false" für "nicht vorhanden"
 * - "countOccurences", welche eine zu suchende Zeichenkette als Parameter und Rückgabewert von Typ int hat
 *   Diese Methode soll die Anzahl Vorkommnisse der Zeichnkette bestimmen
 * 
 * deklarieren, sowie eine Konstante 
 * 
 * - "MAX_COUNT", 
 * 
 * die den Wert 1000 annimmt.
 * Diese Konstante steht dafür, nach wievielen Vorkommnissen die Methode
 * "CountOccurences" abgebrochen werden soll
 */

public interface Searchable { // Durchsuchbar
    /**
     * Anzahl Vorkommnisse, bei welcher die Suche abgebrochen werden darf (mit
     * Rückgabewert MAX_COUNT)
     */
    int MAX_COUNT = 1000;

    /**
     * @param searchString die zu suchende Zeichenkette
     * @return true, falls die gesuchte Zeichenkette gefunden wurde
     */
    boolean search(String searchString);

    /**
     * @param searchString die zu suchende Zeichenkette
     * @param substring    TODO
     * @return die Anzahl der Vorkommnisse der gesuchten Zeichenkette (>=0)
     */
    int countOccurences(String searchString);
}
