# Übung 6

In dieser Übung geht es um Interfaces im Zusammenhang mit Zeichenketten und Arrays.

## Erläuterungen

Folgende Klasse sollen geschrieben werden:

- Ein Interface `Searchable`, welches Such-Funktionen zur Verfügung stellt
- Ein Interface `Addable`, welches eine Methode zum Hinzufügen zur Verfügung stellt
- Eine Klasse `SearchableArray`, welches beide Interfaces basierend auf einem Array von Zeichenketten implmentiert
- Eine Klasse `SearchableString`, welches beide Interfaces basierend auf einer einzigen Zeichenkette implementiert
- Eine Klasse `Main`, welche verschiedene Objekte instanziert und Methoden anwendet und die `main`-Methode enthält

## Zusätze

Wer die Hauptfunktionalität programmiert hat, kann sich folgenden Zusätzen widmen:

- Definieren Sie weitere Klassen, welche die Interfaces `Addable` und/oder `Searchable` implementieren.
  Je origineller, desto besser.
- Definieren Sie ein Interface "Clearable", welches eine "clear" Funktion zur Verfügung stellt, welches
  den Inhalt eines Objekts "löscht". Lassen Sie `SearchableArray` und `SearchableString` auch `Clearable`
  implmentieren.
  