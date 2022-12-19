/*
 * Die Klasse `Int` soll das Interface `RingElement` mit Typvariable `Int` implementieren.
 * Die Klasse soll eine Wrapper-Klasse für `int` sein; einzige Instanzvariable ist von Typ `int`.
 * Ein Konstruktor soll den Wert eines Parameters von Typ `int` übernehmen.
 * Ausserdem soll die `toString`-Methode definiert werden.
 */

public class Int implements RingElement<Int> {
    public int x;

    public Int(int x) {
        this.x = x;
    }

    @Override
    public Int addTo(Int other) {
        return new Int(this.x + other.x);
    }

    @Override
    public Int multTo(Int other) {
        return new Int(this.x * other.x);
    }

    public String toString() {
        return "" + x;
    }
}
