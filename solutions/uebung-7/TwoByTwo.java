/* 
 * Eine 2x2-Matrix ist ein Schema mit 2 Zeilen und 2 Spalten. Es hat also die Form (x11 x12; x21 x22), 
 * wobei (x11 x12) die erste Zeile ist, (x21 x22) die zweite Zeile. Dabei nehmen wir an, dass sich
 * Koeffizienten x11 x12 x21 und x22 der Matrix miteinander addieren und multiplizieren lassen.
 * 
 * 2x2-Matrizen lassen sich komponentenweise addieren: (x11 x12; x21 x22) + (y11 y12; y21 y22) = (x11+y11 x12+y12; x21+y21 x22+y22)
 * 2x2-Matrizen lassen sich multiplizieren: (x11 x12; x21 x22) * (y11 y12; y21 y22) = (r11 r12; r21 r22), wobei
 * r11 = x11*y11+x12*y21, r12 = x11*y12+x12*y22, r21 = x21*y11+x22*y21, r22 = x21*y12+x22*y22.
 * 
 * Die Klasse `TwoByTwo` soll Typvariable `R` für die Komponenten `x11`, `x12`, `x21` und `x22` haben. 
 * Schränken Sie die Typvariable mittels `extends` geeignet ein.
 * Lassen Sie `TwoByTwo` das Interface `RingElement` mit Typ `TwoByTwo<R>` implementieren.
 * 
 * Ein Konstruktor soll die Komponenten `x11`, `x12`, `x21` und `x22` übernehmen.
 * Überschreiben Sie die `toString`-Methode so, dass eine 2x2-Matrix von Typ `Int` durch 
 * die Zeichenkette "Matrix (2 -5; -1 4)" repräsentiert wird.
*/

public class TwoByTwo<R extends RingElement<R>> implements RingElement<TwoByTwo<R>> {
    public R x11;
    public R x12;
    public R x21;
    public R x22;

    public TwoByTwo(R x11, R x12, R x21, R x22) {
        this.x11 = x11;
        this.x12 = x12;
        this.x21 = x21;
        this.x22 = x22;
    }

    @Override
    public TwoByTwo<R> addTo(TwoByTwo<R> other) {
        return new TwoByTwo<R>(x11.addTo(other.x11), x12.addTo(other.x12), x21.addTo(other.x21), x22.addTo(other.x22));
    }

    @Override
    public TwoByTwo<R> multTo(TwoByTwo<R> other) {
        R r11 = x11.multTo(other.x11).addTo(x12.multTo(other.x21));
        R r12 = x11.multTo(other.x12).addTo(x12.multTo(other.x22));
        R r21 = x21.multTo(other.x11).addTo(x22.multTo(other.x21));
        R r22 = x21.multTo(other.x12).addTo(x22.multTo(other.x22));
        return new TwoByTwo<R>(r11, r12, r21, r22);
    }

    @Override
    public String toString() {
        return "Matrix (" + this.x11 + " " + this.x12 + "; " + this.x21 + " " + this.x22 + ")";
    }
}
