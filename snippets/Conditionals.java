import java.util.Random; // für die Erzeugung einer Zufallszahl

public class Conditionals {
    public static void main(String[] args) {
        Random rnd = new Random();
        int number = rnd.nextInt(6) + 1; // Zufällige Ganzzahl im Intervall [1, 6]

        // Einfache Verzweigung:
        if (number == 6) {
            System.out.println("Lucky you, hast eine 6 gewürfelt!");
        }

        // Verzweigung mit verbliebenem Fall
        if (number % 2 == 0) {
            System.out.println("Hast eine gerade Zahl gewürfelt!");
        } else {
            System.out.println("Hast eine ungerade Zahl gewürfelt!");
        }

        // Verzweigung mit Alternativ-Fällen und verbliebenem Fall
        if (number == 1) {
            System.out.println("Buh, eine 1 ist echt unterste Schublade!");
        } else if (number < 3) {
            System.out.println("Schade, nicht mal für eine 3 hats gereicht");
        } else if (number > 4) {
            System.out.println("Stark, hast mindestens eine 5");
        } else {
            System.out.println("Naja, so mittelmässig");
        }

        int score = 20; // Anfans-Score

        // Switch-Anweisung, kann verwendet weden um viele "else if" statements zu
        // verwenden. Wird für ganzzahlige Variablen und enums angewendet, in Java
        // sogar auch für Strings
        switch (number) {
            case 1:
                score += 1;
                break; // springt zum Ende des switch-Blocks
            case 2:
                score += 5;
                break;
            case 3: // mache nichts
                break;
            case 4:
            case 5:
                score += 50; // Tritt nun bei number = 4 und number = 5 ein, da bei case 4 kein
                             // break-Statement steht
                break;
            case 6:
                score *= 10;
                break;
            default:
                System.out.println("Unerwarte Augenzahl: " + number);
        }
        System.out.println("Aus den 20 Punkten wurden " + score + " Punkte!");

        String month = "April";
        switch (month) {
            case "Februar":
                System.out.println("Brr, kalt");
                break;
            case "Juli":
                System.out.println("Ah, warm!");
                break;
            default:
                System.out.println(month + " ist weder Februar noch Juli");
        }
    }
}
