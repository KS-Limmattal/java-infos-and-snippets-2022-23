import java.lang.Math;

public class DataTypes {

    /*
     * Snippet zu Datentypen
     */
    public static void main(String[] args) {

        /*
         * primitive Datentypen
         */
        byte b = 85; // 8-bit Ganzzahl
        short s = 1 << 10; // 16-bit Ganzzahl
        int i = 1 << 20; // 32-bit Ganzzahl
        long l = 1 << 50; // 64-bit Ganzzahl

        float f = 1.05f; // 32-bit Dezimalzahl
        double d = 1.55; // 64-bit Dezimalzahl

        boolean v = true; // Wahrheitswert
        char c = 'a'; // einzelnes Zeichen

        /*
         * Nicht-primitive Datentypen
         */
        // Arrays
        int[] iArr = { 82, 80, 75 };
        double[] dArr = { 1.05, 2.4, -1.5e10 };
        char[] word = { 'W', 'o', 'e', 'r', 't', 'l', 'i' };
        System.out.println("Länge des Worts word: " + word.length);

        // Klassen
        Integer x = i; // Integer Klasse, wrapper für int
        String z = x.toString(); // Zeichenkette
        System.out.println("x als String: " + z);
    }
}