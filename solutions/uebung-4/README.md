# Übung 4

In dieser Übung geht es um abgeleitete Klassen im Kontext von verschiedenen Arten von Lehrpersonen.

## Erläuterungen

Folgende Klassen sollen geschrieben werden:

- Eine Klasse `Teacher`, die eine Lehrperson beschreibt.
- Eine Klasse `LanguageTeacher`, die von `Teacher` erbt, und für eine Sprachlehrperson steht.
- Eine Klasse `ForeignLanguageTeacher`, die von `LanguageTeacher` erbt, und für eine Fremdsprachlehrpersonen steht.
- Eine Klasse `NativeLanguageTeacher`, die von `LanguageTeacher` erbt, und für eine Heimatsprachelehrperson steht.
- Eine Klasse `StemTeacher`, die von `Teacher` erbt, und für eine Lehrperson im MINT-Bereicht steht.
- Eine Klasse `PhysicalEducationTeacher`, die von `Teacher` erbt, und für eine Sport-Lehrperson steht.
- Eine Klasse `TeacherMain`, welche verschiedene Lehrpersonen instanziert und ihre Methoden und Instanzvariablen benutzt.

Nähere Anweisungen finden sich in den einzelnen `.java`-Datei-Vorlagen.

## Zusätze

Wer die Hauptfunktionalität implementiert hat, kann sich folgenden Zusätzen widmen:

- Weitere abgeleitete Klassen von Teacher definieren, so dass alle Fachbereiche abgedeckt sind
- Anstatt nur die Anzahl der Vokabeln eines Sprachlehrers zu kontrollieren, die volle Vokabelliste (als Array) einzubauen
- Eine Sortierfunktion für die soeben eingebaute Vokabelliste implementieren, so dass alphabetisch sortiert wird
