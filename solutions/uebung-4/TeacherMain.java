/**
 * Diese Klasse soll verschiedene Lehrpersonen instanzieren und die Methoden der
 * Klasse Teacher und abgeleiteten Klassen austesten
 * - Erzeugen Sie einen `Teacher anonymous` mit leerem Namen und wenden Sie die
 * Methode `printStatistcs` auf diese Instanz an, um die
 * Korrekturzeiten-Statistik auszugeben
 * - Erzeugen Sie einen `Teacher thomas` mit Name "Thomas" und fügen Sie
 * Korrekturzeiten 5, 3, 12 hinzu und lassen Sie die Korrekturzeiten-Statistik
 * ausgeben
 * - Erzeugen Sie einen `StemTeacher stefan`, der 15 Berechnungen pro Minute
 * schafft, lassen Sie ihn üben mit `practiceCalculation` und geben Sie auf der
 * Konsole Namen und Berechnungen pro Minute aus
 * - Erzeugen Sie einen `PhysicalEducationTeacher martin`, der bereits 2500
 * Liegestützen gemacht hat. Lassen Sie ihn 30 weitere Liegestützen machen und
 * geben Sie die nun gemachte Anzahl Liegestützen, sowie den Namen, aus
 * - Erzeugen Sie eine `ForeignLanguageTeacher martine`, welche 9999 Vokabeln
 * beherrscht
 * und 25.3 Vokabeln pro Minute zu übersetzen vermag. Lassen Sie diese
 * Lehrperson 20 Mal gleichzeitig das Übersetzen üben (`practice`) und ein neues
 * Wort lernen
 * - Erzeugen Sie eine `NativeLanguageTeacher livia`, welche 18500 Vokabeln
 * beherrscht, aber noch keine Fremdsprache kennt. Lassen Sie diese Lehrperson
 * eine Fremdsprache erlernen und 10 Wörter vergessen. Geben Sie danach auf
 * der Konsole aus, wieviele Vokabeln diese Lehrperson beherrscht (inkl. Namen)
 */
public class TeacherMain {
    public static void main(String[] args) {
        Teacher anonymous = new Teacher("");
        anonymous.printStatistics();

        Teacher thomas = new Teacher("Thomas");
        thomas.addCorrectionTime(5);
        thomas.addCorrectionTime(3);
        thomas.addCorrectionTime(12);
        thomas.printStatistics();

        StemTeacher stefan = new StemTeacher("Stefan", 15);
        stefan.practiceCalculation();
        System.out.println(stefan.getName() + " macht durchschnittlich " + stefan.getNumberOfCalculations()
                + " Berechnungen pro Minute");

        PhysicalEducationTeacher martin = new PhysicalEducationTeacher("Martin", 2500);
        martin.practicePushUps(30);
        System.out.println(martin.getName() + " hat bereits " + martin.getNumberOfPushUps() + " Liegestützen gemacht");

        ForeignLanguageTeacher martine = new ForeignLanguageTeacher("Martine", 9999, 25.3f);
        for (int i = 0; i < 20; i++) {
            martine.practice();
            martine.learnsNewWord();
        }
        System.out.println(martine.getName() + " kennt " + martine.vocabularySize
                + " Wörter und braucht zum Übersetzen des gesamten Vokabulars "
                + martine.getTimeToTranslateVocabulary() + " Minuten");

        NativeLanguageTeacher livia = new NativeLanguageTeacher("Livia", 18500, false);
        livia.learnsForeignLanguage();
        for (int i = 0; i < 10; i++) {
            livia.forgetsWord();
        }
        System.out.println("Livia kennt " + livia.vocabularySize + " Wörter");
    }
}
