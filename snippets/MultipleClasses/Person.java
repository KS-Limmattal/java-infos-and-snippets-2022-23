public class Person {
    private String name;
    private int age;

    public static final int MAX_AGE = 130; // eine Konstante (final), Klassenvariable

    private static int personCount = 0; // eine Klassenvariable, welche immer um eins erhöht wird, wenn eine neue Person
                                        // konstruiert wird

    // Konstruktor 1
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        personCount++;
    }

    // Konstruktor 2
    public Person(String name) {
        this(name, 0); // Neugeborenes, ruft Konstuktor 1 mit age=0 auf
    }

    // triviale Getter und Setter, mit welcher andere Klassen auf die
    // Instanzvariablen zugreifen können
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Nicht-triviales Getter/Setter Paar
    public int getAge() {

        return this.age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Ignoriere, da Alter nicht negativ sein kann");
            return;
        }
        if (age > MAX_AGE) {
            System.out.println("Das scheint zu hoch, bitte überprüfen. ");
        }
        this.age = age;
    }

    /*
     * Empfehlung bzgl. Getter/Setter für Instanzvariablen:
     * - verwende das private-Schlüsselwort und verzichte auf Getter/Setter, wenn
     * andere Klassen diese Instanzvariable nichts angeht
     * - verwende das private-Schlüsselwort und verzichte auf einen Setter, wenn
     * andere Klassen diese Instanzvariable zwar lesen, aber nicht ändern sollen
     * - verwende das private-Schlüsselwort und füge Getter/Setter hinzu, wenn es
     * ein nicht-triviales Getter/Setter Paar ist oder absehbar ist, dass es in ein
     * nicht-triviales Paar umgewandelt werden muss
     * - verwende das public Schlüsselwort, falls jede Klasse die Instanzvariable
     * lesen und ändern dürfen soll und kein nicht-triviales Getter/Setter Paar
     * nötig ist
     */

    public String toString() {
        return "Person namens " + this.name + " von Alter " + this.age;
    }

    public void increaseAge() {
        this.age += 1;
    }

    // statische Methode, greift nur auf statische Variable personCount zu
    public static void printPersonCount() {
        System.out.println("Anzahl Personen erzeugt: " + personCount);
    }
}
