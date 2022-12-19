/* 
 * Ein 3d-Vektor (x,y,z) hat 3 Komponenten `x`, `y` und `z`. 
 * Zwei Vektoren können komponentenweise addiert werden: (x,y,z) + (u,v,w) = (x+u,y+v,z+w)
 * Ein Vektor kann mit einem Skalar multipliziert werden: s*(x,y,z) = (s*x, s*y, s*z)
 * 
 * Die Klasse `Vect3` soll Typvariable `R` für den Typ der Komponenten `x`, `y` und `z` haben, 
 * welche von `RingElement<R>` abgeleitet ist. 
 * (Erklärung: die Komponenten sollen mit Objekten derselben Art addiert/multipliziert werden können)
 * 
 * Ein Konstruktor soll die Komponenten `x`, `y` und `z` übernehmen. 
 * Die `toString`-Methode soll definiert werden, dass ein 3d-Vektor von Typ `Int` z.B. als 
 * "Vektor (5,2,-3)" dargestellt wird
*/

public class Vect3<R extends RingElement<R>> {
    public R x;
    public R y;
    public R z;

    public Vect3(R x, R y, R z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vect3<R> addTo(Vect3<R> other) {
        return new Vect3<R>(x.addTo(other.x), y.addTo(other.y), z.addTo(other.z));
    }

    public Vect3<R> scale(R scalar) {
        return new Vect3<R>(scalar.multTo(x), scalar.multTo(y), scalar.multTo(z));
    }

    @Override
    public String toString() {
        return "Vektor (" + x + ", " + y + ", " + z + ")";
    }
}
