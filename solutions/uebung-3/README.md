# Übung 3

In dieser Übung geht es um den Einsatz von (mehreren) Klassen im Kontext des Jass-Spiels
(mit Deutsch-Schweizer Karten)

## Erläuterungen

Die `enum`s `Suit` und `Rank` (`Suit.java` und `Rank.java`) sind vorgegeben und brauchen nicht
verändert zu werden.

Folgende Klassen sollen geschrieben werden:

- `Card`: Steht für eine einzelne Karte
- `Deck`: Steht für einen Kartenstapel (mit einer variablen Anzahl Karten)
- `Jass`: Dies ist die Hauptklasse (enthält die main-Methode)

Nähere Anweisungen finden sich in den einzelnen `.java`-Datei-Vorlagen.

## Zusätze

Wer die Hauptfunktionalität implementiert hat, kann sich folgenden Zusätzen widmen:

- Fügen Sie in der Klasse `Deck` eine öffentliche Instanzvariable von Typ `Suit` hinzu, welche für den Trumpf steht
- Fügen Sie darauf in der Klasse `Deck` eine Methode `validCards(Deck played)` hinzu, welche aus `this.cards` die Karten zurückliefert, welche ausgespielt werden können, wenn zuvor die (maximal 3) Karten aus dem Deck `played` gespielt worden sind.
- Generieren Sie in der Klasse `Jass` einen gültigen Schieber-Jass zwischen 4 Computerspieler, welche jeweils gültige Karten ausspielen
- Erlauben Sie dem Benutzer mitzuspielen. Die Karten in seiner Hand sollen jeweils angezeigt werden. Der Spieler soll
per Konsole eingeben, welche Karte er ausspielen möchte. Das Programm darf nur gültige Karten als Eingabe akzeptieren.
