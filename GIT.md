# Arbeit mit Git

`Git` ist ein leistungsfähiges Versionskontroll-System, welches besonders gut beim Programmieren eingesetzt werden kann.
Gerade bei Zusammenarbeit von mehreren ProgrammiererInnen ist ein Versionskontroll-System unabdingbar, da so mehrere Personen
unabhängig am gleichen Projekt arbeiten können. Es bietet aber auch für einzelne ProgrammiererInnen viele Vorteile.
Zum Beispiel lassen sich Änderungen an den Teilen des Projekts schnell inspizieren, modifizieren oder rückgängig machen.
Ausserdem kann an verschiedenen Projekt-Features unabhängig gearbeitet werden.

Jedes Programmierprojekt wird in einem `Repository` abgelegt. Dies ist ein virtueller Speicher, welches aus der Kollektion
der Dateien des Projekts und Metadata zur Versionskontrolle besteht. Jede substanzielle Code-Änderung
wird in einem `Commit` zur Projekt-Geschichte hinzugefügt und mit einer Überschrift betitelt.
`Github` ist ein internet-basierter Dienst zum Einsatz von `Git`. Beginnt man `Github` zu verwenden, sind einige Konfigurationsschritte nötig,
die im folgenden [Video](https://www.youtube.com/watch?v=kHkQnuYzwoo) erklärt werden.

## Projekt-Geschichte

Die Projekt-Geschichte lässt sich mittels

```term
git log
```

anzeigen. Ein Beispiel aus dem Schwerpunktsfach (Python-Programmierung):

![grafik](https://user-images.githubusercontent.com/40485433/131213722-0036b625-5480-4bc8-9c74-214081c4cc6d.png)

Es ist daraus also ersichtlich, wer wann welche Commits gemacht hat und was damit bezweckt werden sollte.

## Aktueller Zustand

Der aktuelle Zustand des Git Repositories lässt sich mittels

```term
git log
```

anzeigen. Hier wird ersichtlich, ob es geänderte Dateien gibt, ob diese bereits für einen neuen Commit vorgemerkt sind (grün statt rot) und ob gerade ein
"Merge" oder "Rebase" Prozess zur Zusammenführung von Dateien im Gange ist. Ausserdem wird der aktuelle Branch (Zweig) angezeigt, auf welchem gearbeitet wird.

Zum Beispiel zeigt:

```term
Auf Branch main
Ihr Branch ist auf demselben Stand wie 'origin/main'.

Änderungen, die nicht zum Commit vorgemerkt sind:
  (benutzen Sie "git add <Datei>...", um die Änderungen zum Commit vorzumerken)
  (benutzen Sie "git restore <Datei>...", um die Änderungen im Arbeitsverzeichnis zu verwerfen)
 geändert:       snippets/loops.py

Unversionierte Dateien:
  (benutzen Sie "git add <Datei>...", um die Änderungen zum Commit vorzumerken)
 other/

keine Änderungen zum Commit vorgemerkt (benutzen Sie "git add" und/oder "git commit -a")
```

an, dass auf dem Hauptzweig `main` gearbeitet wird und dass es eine geänderte Datei `snippets/loops.py` gibt, die mittels `git add snippets/loops.py`
für einen Commit vorgemerkt werden kann. Auch das Verzeichnis `other/` ist neu und kann hinzugefügt werden.

## Änderungen bereitstellen und veröffentlichen

Anstatt die neusten Code-Dateien auf Github im Web-Interface reinzukopieren und so zu veröffentlichen, lautet der Ablauf aus der Kommandozeile wie folgt:

```term
git add <Dateiname(n)>
git commit -m "Commit-Nachricht"
git push
```

Dabei sollte im Zweifelsfall vorher mittels

```term
git fetch
git status
```

überprüft werden, ob der aktuelle Zweig im lokalen Repository im selben Zustand wie das Online Repository ist. Allenfalls müssen mit

```term
git pull
```

die neuesten Änderungen im Online Repository heruntergeladen werden.

## Klonen von Repositories

Um ein Repository vom Online-Dienst Github zu klonen, verwendet man den Befehl `git clone`.

Um etwa das `java-info-and-snippets` Repository zu klonen, besucht man die Seite [https://github.com/KS-Limmattal/java-infos-and-snippets](https://github.com/KS-Limmattal/java-infos-and-snippets), kopiert den Link oben rechts und
tippt dann im gewünschten Verzeichnis in der Konsole:

```term
git clone https://github.com/KS-Limmattal/java-infos-and-snippets.git
```
