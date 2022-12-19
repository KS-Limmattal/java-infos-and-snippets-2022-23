/* 
 * Die Klasse `Fract` soll einen Bruch n/d von Ganzzahlen repräsentieren und das 
 * `RingElement`-Interface implementieren (vgl. Klasse `Int`). 
 * Instanzvariablen sind n (numerator) und d (denominator)
 * Schreiben Sie auch einen Konstruktor und überschreiben Sie die `toString`-Methode, 
 * so dass ein Bruch in der Form "-2/15" dargestellt wird.
 * 
*/

public class Fract implements RingElement<Fract> {
    int n; // numerator = Zähler
    int d; // denominator = Nenner

    public Fract(int n, int d) {
        this.n = n;
        this.d = d;
    }

    @Override
    public Fract addTo(Fract other) {
        return shorten(new Fract(this.n * other.d + this.d * other.n, this.d * other.d));
    }

    @Override
    public Fract multTo(Fract other) {
        return shorten(new Fract(this.n * other.n, this.d * other.d));
    }

    public Fract shorten(Fract f) {
        int n = f.n;
        int d = f.d;
        boolean divisible;
        do {
            divisible = false;
            int m = Math.max(n, d);
            for (int x = 2; x <= m; x++) {
                if (d % x == 0 && n % x == 0) {
                    divisible = true;
                    n = n / x;
                    d = d / x;
                    break;
                }
            }
        } while (divisible);
        return new Fract(n, d);
    }

    @Override
    public String toString() {
        if (this.d == 1) {
            return this.n + "";
        } else if (this.d == -1) {
            return (-this.n) + "";
        }
        return this.n + "/" + this.d;
    }
}
