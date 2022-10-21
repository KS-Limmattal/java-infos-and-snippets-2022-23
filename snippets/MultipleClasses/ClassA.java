public class ClassA {
    private int someNumber;
    private String someString;

    /**
     * @brief Konstruktor
     */
    public ClassA(int someNumber, String someString) {
        this.someNumber = someNumber; // der Instanzvariablen this.someNumber wird der Parameter someNumber des
                                      // Konstruktors zugewiesen
        this.someString = someString;
    }

    /**
     * @brief Schreibt den String someString so oft hin, wie someNumber anzeigt.
     *        Nicht-statische Methoden der Klasse können auf alle Instanzvariablen
     *        zugreifen.
     */
    public void printString() {
        for (int i = 0; i < this.someNumber; i++) {
            System.out.println(this.someString);
            // Es geht hier auch System.out.println(someString); da im Gegensatz zum
            // Konstruktor keine lokale Variable someString vorhanden ist
        }
    }
}
