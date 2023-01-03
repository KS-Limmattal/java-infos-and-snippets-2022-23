# Übung 7

In dieser Übung geht es um generische Klassen und Methoden im Zusammenhang mit `3d`-Vektoren und `2x2`-Matrizen.

## Erläuterungen

Folgende Klasse sollen geschrieben werden:

- Ein Interface `RingElement` mit generischem Typ für Objekte, die addiert und multipliziert werden können
- Eine Wrapper-Klasse `Int` für `int`(Ganzzahlen), welche `RingElement<Int>` implementiert
- Eine Klasse `Vect3` für `3d`-Vektoren `(x,y,z)`, welche addiert und mit einem Skalar multipliziert werden können
- Eine Klasse `Fract` für Brüche von Ganzzahlen, welche `RingElement<Fract>` implementiert
- Eine Klasse `TwoByTwo` für `2x2`-Matrizen `(x11 x12; x21 x22)`, welche addiert und multipliziert werden können
- Eine Klasse `VectorsAndMatricesMain`, welche verschiedene `3d`-Vektoren und `2x2`-Matrizen instanziert und addiert/multipliziert und über eine generische Methode zur Ausgabe einer Aufzählung der Elemente eines Arrays verfügt

## Zusätze

- Ändern Sie die `toString`-Methode von `Fract` so ab, dass Brüche mit Nenner `1` oder `-1` wie Ganzzahlen dargestellt werden.
- Fügen Sie der Klasse `Fract` eine Methode `simplify` hinzu, welche zur Instanz von `Fract` einen gekürzten Bruch zurückgibt. Schreiben Sie die Methoden `addTo` und `multTo` so um, dass der Rückgabewert gekürzt wird
- Schreiben Sie weitere Klassen, die `RingElement` implementieren. Wie wäre es z.B. mit Polynomen mit ganzzahligen Koeffizienten?
