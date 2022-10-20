public class Methods {
    /**
     * Eine Methode in Java ist eine Folge von Anweisungen, die optional einen oder
     * mehrere Werte an den Aufrufer zurückliefern. Der Methode können 0 oder mehr
     * Argumente übergeben werden, die in der Ausführung der Methode verwendet
     * werden können.
     * 
     * Methoden werden als
     * 
     * static <returntype> <functionname>(<arguments passed to the function>) {
     * // Tu was
     * }
     * 
     * geschrieben, also z.B.
     * 
     * static int countWords(String s) {
     * // Auszuführender Code
     * }
     * 
     * für eine Methode mit Rückgabetyp "int" und ein einzelnes Argument von Typ
     * "String"
     * 
     * Das Schlüsselwort "static" steht dafür, dass die Funktion nicht von einem
     * Objekt der Klasse abhängt. Mehr dazu im "Classes.java"-Snippet
     * 
     * Soll eine Methode nur etwas tun, aber nichts zurückliefern, so wird der
     * Rückgabetyp "void" verwendet.
     * Ist der Rückgabe-Typ nicht "void", so muss die Methode ein
     * "return"-Statement enthalten, welches die
     * gewünschte Rückgabe zurückliefert und die Ausführung der Methode abbricht.
     */

    /**
     * @brief Die main-Methode wird automatisch ausgeführt. In diesem snippet dient
     *        die main-Methode dazu, die anderen Methoden aufzurufen
     * @param args Eine Array von Zeichenketten (String), die bei der Ausführung der
     *             Klasse übergeben werden müssen
     */
    public static void main(String[] args) {
        double x = 5.5;
        double inv = additiveInverse(x); // Hier wird die Methode "additiveInverse" aufgerufen.
        System.out.println("Gegenzahl von x = " + x + " ist " + inv);

        sayHello(); // Hier wird die Methode "sayHello" aufgerufen. Sie hat keinen Rückgabewert.

        sayThoseThreeWords("Jetzt", "ist", "Schluss"); // Diese Methode hat 3 Parameter

        System.out.println("Der Sinn des Lebens lautet: " + meaningOfLife()); // Hier wird der Rückgabewert direkt
                                                                              // verwendet, ohne Zuweisung

        int[] b = { 2, 5, 9, 7, 5, 2, 2, 6, 9, -3, 4, 4 };
        int[] d = duplicates(b); // sollte {2, 5, 9, 4} sein
        for (int y : d) {
            System.out.print(y + " ");
        }

        int n = 20;
        System.out.println("Die Summe der ersten " + n + " Quadratzahlen ist gleich " + sumOfSquares(n));
    }

    /**
     * 
     * @param x Fliesskommazahl
     * @return additive Inverse der Zahl
     */
    static double additiveInverse(double x) {
        return -x;
    }

    /**
     * @brief Funktion ohne Argumente und Rückgabewert, welche "Hello you" auf die
     *        Konsole schreibt.
     */
    static void sayHello() {
        System.out.println("Hello you! ");
    }

    /**
     * @brief Gibt drei Wörter auf der Konsole aus
     * @param s1 erstes Wort
     * @param s2 zweites Wort
     * @param s3 drittes Wort
     */
    static void sayThoseThreeWords(String s1, String s2, String s3) {
        System.out.println("1. Wort: " + s1);
        System.out.println("2. Wort: " + s2);
        System.out.println("3. Wort: " + s3);
    }

    /**
     * @return Der Sinn des Lebens (als Ganzzahl)
     */
    static int meaningOfLife() {
        return 42;
    }

    /**
     * @param a Array von Ganzzahlen (int)
     * @return Array von Ganzzahlen bestehend aus den Duplikaten von a (je einmal)
     */
    static int[] duplicates(int[] a) {
        int[] ret = new int[a.length]; // wird am Schluss noch auf die passende Länge getrimmt
        boolean[] isDuplicate = new boolean[a.length];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (isDuplicate[i]) {
                continue;
            }
            boolean first = true; //
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == a[i]) {
                    isDuplicate[j] = true; // Index i muss nicht als Duplicate markiert werden, da später nicht
                                           // verwendet
                    if (first) {
                        ret[count++] = a[i];
                    }
                    first = false;
                }
            }
        }
        return java.util.Arrays.copyOf(ret, count);
    }

    /**
     * @param n Anzahl der zu addierenden Quadratzahlen
     * @return Summe der ersten n Quadratzahlen
     */
    static int sumOfSquares(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return sumOfSquares(n - 1) + n * n; // Wenn eine Funktion sich selbst aufruft, so nennt man dies Rekursion
        }
    }
}
