# Übung 8

In dieser Übung geht es um Listen (Stacks und Queues), die auf der Basis von Array-Listen implementiert werden.

## Erläuterungen

Die abstrakte Klasse `List` ist bereits implementiert. Studieren Sie sie zuerst und stellen sicher, dass Sie die Methoden verstanden haben.

Danach sollen folgende Klassen geschrieben werden:

- Generische Interfaces `Stack` und `Queue`. `List` implementiert die beiden Interfaces bereits.
- Eine von `List` abgeleitete Klasse `ArrayList` mit generischem Typ.
- Eine Klasse `ListTester`, die die Klassen `ArrayList` und `DynamicArrayList` als Stack und als Queue auf Funktionalität und Performance testet.
- Eine Klasse `DynamicArrayList`, die von `ArrayList` erbt. Überschreiben Sie die nötigen Methoden, um die Arrayliste dynamisch zu machen.

## Zusätze

- Implementieren Sie die fehlenden noch nicht funktionierenden von `List` geerbten Methoden in `ArrayList` (und stellen Sie sicher, dass sie auch in `DynamicArrayList` funktionieren).
- Schreiben Sie eine weitere von `ArrayList` oder `DynamicArrayList` abgeleitete Klasse, die sowohl als Stack als auch als Queue effizient funktioniert. Geben Sie ihr einen sinnvollen Namen.
- Finden Sie weitere Möglichkeiten, um Array-basierte Listen effizienter zu machen.

