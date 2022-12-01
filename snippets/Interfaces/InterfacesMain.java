/*
 * In engem Zusammenhang mit abstraken Klassen stehen sog. Interfaces (Schnittstellen).
 * Ein Interface verfügt nur über abstrakte Methoden und statische, konstante Variablen. 
 * Sie speichert also keinen Zustand (es gibt keine Instanzvariablen), sondern definiert 
 * eine gewisse Funktionalität, die von verschiedenen Klassen implementiert werden kann.
 * 
 * Eine Klasse kann ein Interface "implementieren" und zwar in der Form:
 * 
 * public class A implements B {
 *   // Code
 * }
 * 
 * wobei B das Interface bezeichnet. Anstatt "extends" wird also "implements" geschrieben.
 * Eine Klasse kann mehrere Interface gleichzeitig implementieren, in der Form:
 * 
 * public class A implements B, C {
 *   // Code
 * }
 * 
 * Bei der Vererbung geht es darum, dass eine abgeleitete Klasse eine besondere Art einer
 * Basisklasse ist, z.B. sind "Rectangle" und "Circle" besondere Arten von "Form".
 * Bei Interfaces geht es hingegen darum, gewisse Funktionalität auf einheitliche Weise, 
 * frei von deren konkreten Implementierung anzubieten. 
 * Die implementierende Klasse geht quasi einen Vertrag mit dem Interface ein. Es muss 
 * dessen Methoden definieren. Ein Interface definiert nur einen Aspekt einer Klasse,
 * nicht den Kern der Klasse. Verschiedene Aspekte können über verschiedene Interfaces
 * definiert sein.
 * 
 * Da Interfaces keinen Zustand, sondern nur abstrakte Methoden und statische Konstanten
 * haben, sind alle darin definierten Methoden automatisch abstrakt und ausserdem 
 * öffentlich. Man braucht also nicht "public abstract" im Interface zu schreiben, denn
 * das ist automatisch.
 * Alle darin definierten Variablen sind automatisch öffentlich, statisch und konstant. 
 * Man braucht also nicht "public static final" zu schreiben, denn das ist automatisch.
 * 
 * Interfaces haben (auf Englisch) oft Namen, die auf "able" enden. Weit verbreitet sind
 * etwa die Interfaces "Comparable", "Cloneable", "Seriazable", "Observable" etc.
 * 
 * Interfaces sollten mit Voraussicht konzipiert werden. Es ist schwierig, ein Interface
 * im Nachhinein abzuändern. Nämlich müssen alle implementierenden Klassen alle
 * Methoden des Interfaces definieren (da diese abstrakt sind). Fügt man also eine
 * einzige weitere Methode hinzu, so müssen alle implementierenden Klassen ergänzt
 * werden.
 * 
 * In diesem Snippet implementieren die Klassen "Bottle" und "Battery" das Interface
 * "Fillable" (beide können aufgefüllt werden). Die Klasse "Battery" implementiert
 * ausserdem ein zweites Interfaces "Recycable" (sie ist auch rezyklierbar)
 * 
 */

public class InterfacesMain {
    public static void main(String[] args) {
        Bottle drinkingBottle = new Bottle(1500, "Coca Cola");
        Battery iPhoneBattery = new Battery(50, 1400);

        Fillable[] fillables = { drinkingBottle, iPhoneBattery };
        for (Fillable fillable : fillables) {
            if (fillable.isEmpty()) {
                System.out.println(fillable + " ist leer");
            }

            fillable.empty();
            assert (fillable.isEmpty());

            for (int i = 0; i < 10; i++) {
                fillable.fillUp();
            }
        }

        iPhoneBattery.recycle();
    }

}
