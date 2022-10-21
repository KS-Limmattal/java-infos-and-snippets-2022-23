public class ClassesMain {
    /**
     * Eine Klasse ist ein Bauplan für Objekte eines bestimmten Typs.
     * Eine Instanz einer Klasse ist eine Realisierung dieses Bauplans.
     * 
     * Klassen haben
     * - Variablen, welche den Zustand der Klasse bzw. einer Instanz der Klasse
     * darstellen
     * - Methoden, welche über die Klasse bzw. Instanzen davon aufgerufen werden
     * können und eine Zustandsänderung erlauben
     * 
     * Der Vorteil von Klassen liegt darin, dass Variablen und Methoden, die zum
     * selben Typ von Objekt gehören, gebündelt werden können.
     * 
     * In Java wird jede Klasse (mit Ausnahme etwa von "inneren Klassen", welche nur
     * im Kontext der äusseren Klasse sichtbar sind) in einer separaten Datei
     * gespeichert, die den Namen <Klassenname>.java trägt.
     * 
     * Eine Klasse (Bauplan) muss zuerst definiert werden, bevor Instanzen der
     * Klasse angelegt werden können.
     * Bei der Instanzierung von Objekten wird ein Konstruktor der Klasse
     * aufgerufen. Ein Konstruktor dient vor allem dazu, den Instanzvariablen Werte
     * zuzuweisen. Ein Konstruktor trägt den Namen der Klasse und kann mit
     * unterschiedlichen Argumenten (mehrfach) definiert sein.
     * 
     * Es wird sowohl bei Variablen wie auch bei Methoden zwischen statischen und
     * nicht-statischen (gewöhnlichen) Variablen/Methoden unterschieden.
     * 
     * Statisch bedeutet dabei, dass die Variable/Methode nur einmal pro Klasse
     * (nicht pro Instanz) gespeichert ist. Sie hängen nicht von einer konkreten
     * Instanz der Klasse ab. Statische Methoden können darüberhinaus nur auf
     * statische Variablen der Klasse zugreifen. Sie erfordern keine Instanzierung
     * und werden über Klassenname.methodenname(<Argumente>) aufgerufen.
     * Die main-Methode muss immer statisch deklariert werden.
     * 
     * Sowohl Variablen wie auch Methoden können verschiedene Sichtbarkeit haben,
     * nämlich "public", "protected" oder "private". Dieses Schlüsselwort wird
     * bei der Deklaration der Variable/Methode vorangehängt, z.B.
     * "private String name", "public String getName()" etc. Dabei bedeutet
     * - private: kann nur innerhalb der Klasse verwendet werden
     * - protected: kann innerhalb der Klasse und allen "abgeleiteten" Klassen
     * verwendet werden -> siehe (künftiges) snippet zu "Inheritance"
     * - public: ist auch in anderen Klassen sichtbar
     * 
     * Bei der Sichtbarkeit geht es darum, Instanzvariablen vor unvorgesehenem
     * Zugriff zu schützen.
     * Instanzvariablen sind typischerweise "private", Konstanten meist "public"
     * 
     * Wie Python (__str__-Methode) hat auch Java einen vorgegebenen Methoden-Namen
     * für die Darstellung als Zeichenkette (die System.out.print verwendet wird),
     * nämlich "public String toString()"
     */

    public static void main(String[] args) {
        // Konstruiere eine Instanz der Klasse ClassA und wende die printString-Methode
        // darauf an
        ClassA instanzA = new ClassA(10, "Hallo");
        instanzA.printString();

        // Konstruiere vier Personen (Instanzen der Klasse Person) und speichere sie in
        // einem Array
        Person[] pupils = {
                new Person("Fridolin", 18),
                new Person("Susi", 17),
                new Person("Hildegard", 17),
                new Person("Otto", 16)
        };

        for (Person person : pupils) {
            System.out.println(person); // Verwendet toString() Methode von Person
        }
        Person newBorn = new Person("Bebe"); // mit Konstruktor 2 der Klasse Person konstruiert
        System.out.println(newBorn);

        Person.printPersonCount(); // Aufruf einer statischen Methode der Klasse

        pupils[0].setAge(-10); // wird ignoriert
        System.out.println(pupils[0]);
        pupils[1].setAge(200); // wird akzeptiert, jedoch mit Warnung
        System.out.println(pupils[1]);
        pupils[2].increaseAge(); // wird akzeptiert, jedoch mit Warnung
        System.out.println(pupils[2]);
    }
}
