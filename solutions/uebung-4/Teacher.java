
/**
 * Diese Klasse repräsentiert eine Lehrperson.
 * Jede Lehrperson hat 
 * - einen Namen `name`, 
 * - ein Array `correctionTimes` von ganzzahligen Korrekturzeiten (in Tagen), 
 * - eine Anzahl `examsCorrected` von bisher korrigierten Prüfungen. 
 * - einen Zufallsgenerator `rnd`, Instanz der Klasse `java.util.random`
 * 
 * Der Konstruktor soll nur den Namen übernehmen und mit 0 korrigierten Prüfungen beginnen. 
 * Das Array `correctionTimes` soll dabei Grösse `MAX_EXAMS = 100` erhalten. 
 * 
 * Für `name` soll es einen trivialen Getter und einen nicht-trivialen Setter geben, 
 * wobei letzterer im Falle eines leeren Namens einen Namen wie "Lehrer_874" mit 
 * zufälliger höchstens 3-stelliger id generiert. 
 * 
 * Für `correctionTimes` soll es einen trivialen Getter sowie eine Methode 
 * `addCorrectionTime(int time)` zum Hinzufügen einer Korrekturzeit zu `correctionTimes`
 * geben, bei welcher überprüft wird, ob die Korrekturzeit `time` nicht-negativ ist 
 * und ob nicht mehr als `MAX_EXAMS` Prüfungen geschrieben sind, mit entsprechenden Warnungen. 
 * 
 * Weiter soll es folgende Methoden geben:
 * - Eine Methode `getAverageCorrectionTime` soll die durchschnittliche Korrekturzeit 
 * pro Prüfung (in Tagen) zurückliefern
 * - Eine Methode `printStatistics` soll einen Satz der Form 
 * `XYZ hat durchschnittliche Korrekturzeit u Tage`, repsektive eine Warnung im Falle, 
 * dass die Lehrperson noch keine Prüfungen korrigiert hat, auf die Konsole schreiben.
*/

import java.util.Random;

public class Teacher {
    private String name;
    private int examsCorrected;
    public static final int MAX_EXAMS = 100;
    private int[] correctionTimes; // Korrekturzeiten in Tagen
    private Random rnd;

    public Teacher(String name) {
        rnd = new Random();
        this.setName(name);
        correctionTimes = new int[MAX_EXAMS];
        examsCorrected = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            this.name = "Lehrer_" + rnd.nextInt(1000);
        } else {
            this.name = name;
        }
    }

    public int[] getCorrectionTimes() {
        return this.correctionTimes;
    }

    public void addCorrectionTime(int time) {
        if (time < 0) {
            System.out.println("Negative Korrekturzeit ist unmöglich!");
        } else if (examsCorrected >= MAX_EXAMS) {
            System.out.println("Kann keine Korrekturzeit hinzufügen, da schon die maximale Anzahl von " + MAX_EXAMS
                    + " Examen geschrieben sind. ");
        } else {
            correctionTimes[examsCorrected++] = time;
        }
    }

    public float getAverageCorrectionTime() {
        float s = 0.f;
        for (int t : this.correctionTimes) {
            s += (float) t;
        }
        return s / examsCorrected;
    }

    public void printStatistics() {
        if (examsCorrected == 0) {
            System.out.println(this.getName() + " hat noch keine Prüfungen korrigiert!");
        } else {
            System.out.println(this.getName() + " hat durchschnittliche Korrekturzeit "
                    + this.getAverageCorrectionTime() + " Tage");
        }
    }
}