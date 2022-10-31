/**
 * Diese Klasse stellt eine Sport-Lehrperson dar.
 * Sie erbt direkt von Teacher. Eine Instanz der Klasse verfügt über
 * eine Ganzzahl `numberOfPushUps` von total gemachten Liegestützen.
 * 
 * Der Konstruktor soll den Namen und die Anzahl Liegestützen übernehmen.
 * 
 * Für `numberOfPushUps` soll es einen trivialen Getter sowie eine Methode
 * `practicePushUps(int count)` geben, welche die Variable `numberOfPushUps`
 * entsprechend erhöht. Im Falle einer negativen Zahl `count` soll die Methode
 * eine Warnung ausgeben.
 */

public class PhysicalEducationTeacher extends Teacher {
    private int numberOfPushUps; // Anzahl Liegestützen total gemacht

    public PhysicalEducationTeacher(String name, int numberOfPushUps) {
        super(name);
        this.numberOfPushUps = numberOfPushUps;
    }

    public void practicePushUps(int count) {
        if (count < 0) {
            System.out.println("Es ist nicht möglich, eine negative Anzahl Liegestützen zu machen");
        } else {
            this.numberOfPushUps += count;
        }
    }

    public int getNumberOfPushUps() {
        return this.numberOfPushUps;
    }
}