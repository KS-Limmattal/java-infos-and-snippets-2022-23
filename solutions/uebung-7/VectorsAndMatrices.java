/* 
 * Die Klasse `VectorsAndMatrices` soll die `main`-Methode sowie eine statische Methode `printWithClassInfo` enthalten.
 * 
 * In der `main`-Methode sollen ganzzahlige 3d-Vektoren (2,3,5) und (1,-1,2) instanziert werden. Lassen Sie die Summe
 * der beiden Vektoren berechnen und ausgeben, sowie das 10-fache des ersten Vektoren.
 * Ausserdem sollen drei Matrizen (2 3; -1 4), (1 -2; 5 0) und (1/2 4; -1/2 2) instanziert werden. Lassen Sie das 
 * Produkt der ersten beiden Matrizen (beide mit ganzzahligen Koeffizienten) berechnen und ausgeben, 
 * sowie die zweite Potenz der dritten Matrix (mit gebrochenen Koeffizienten)
 * 
 * Schreiben Sie zudem eine statische Methode mit parametrisiertem Typ namens `printWithClassInfo`. Diese Methode soll ein
 * Array von variablem Typ als Parameter haben und nichts zurückgeben, sondern die Klasse dieser Array-Elemente 
 * (mit Hilfe von `.getClass().getName()` angewendet auf das erste Array-Element) ausgeben, sowie in einer Aufzählung alle
 * Elemente des Arrays.
 * Wenden Sie die `printWithClassInfo` Methode in der `main`-Methode auf das `Vect3`-Array bestehend aus den beiden Vektoren, 
 * sowie auf das `TwoByTwo`-Array bestehend aus den drei Matrizen an.
*/

public class VectorsAndMatrices {
    public static void main(String[] args) {
        Vect3<Int> v = new Vect3<Int>(new Int(2), new Int(3),
                new Int(5));
        Vect3<Int> w = new Vect3<Int>(new Int(1), new Int(-1),
                new Int(2));
        printWithClassInfo(new Vect3[] { v, w });

        System.out.println(v + " + " + w + " = " + v.addTo(w));
        Int s = new Int(10);
        System.out.println(s + " * " + v + " = " + v.scale(s));
        System.out.println();

        TwoByTwo<Int> A = new TwoByTwo<Int>(new Int(2), new Int(3), new Int(-1), new Int(4));
        TwoByTwo<Int> B = new TwoByTwo<Int>(new Int(1), new Int(-2), new Int(5), new Int(0));
        TwoByTwo<Fract> C = new TwoByTwo<Fract>(new Fract(1, 2), new Fract(4, 1), new Fract(-1, 2), new Fract(2, 1));
        printWithClassInfo(new TwoByTwo[] { A, B, C });

        System.out.println(A + " + " + B + " = " + A.addTo(B));
        System.out.println(A + " * " + B + " = " + A.multTo(B));
        System.out.println(C + "**2 = " + C.multTo(C));
    }

    public static <T> void printWithClassInfo(T[] list) {
        System.out.println("Aus Klasse " + list[0].getClass().getName() + ":");
        for (T obj : list) {
            System.out.println("- " + obj);
        }
    }
}
