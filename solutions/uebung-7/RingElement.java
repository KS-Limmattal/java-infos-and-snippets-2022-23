/* 
 * Schreiben Sie ein Interface `RingElement` mit parametrisiertem Typ, welches eine 
 * `addTo` und eine `multTo`-Methode für Objekte mit entsprechendem Typ deklariert.
 * 
 * Anstatt `RingElement` könnte man das Interface auch z.B. "AddableAndMultipliable" nennen.
 * In einem Ring erfüllen die Addition und Multiplikation gewisse Regeln. Wir werden uns
 * aber nicht darum kümmern, ob die Regeln erfüllt sind.
 * 
 * Beachten Sie: In Java können Operatoren (wie +, * etc.) nicht überschrieben werden.
 * Statt `v+w` schreibt man für benutzerdefinierte Typen also z.B. `v.addTo(w)`
*/

public interface RingElement<T> {
    T addTo(T other);

    T multTo(T other);
}
