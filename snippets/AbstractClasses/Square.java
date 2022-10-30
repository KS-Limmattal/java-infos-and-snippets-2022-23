public class Square extends Rectangle {
    private double side;

    // Konstruktor
    public Square(String name, double side) {
        super(name, side, side); // Ruft den Konstruktor der Klasse auf, wovon die Klasse abgeleitet ist, also
                                 // den Konstruktor der Klasse "Rectangle"
    }

    // Methode, welche nur die Klasse Square (und evtl. davon abgeleitete Klassen)
    // enthält
    public double getSide() {
        return this.side;
    }

    // Die Methode getArea() muss hier nicht überschrieben werden, da sie schon in
    // der Klasse Rectangle definiert ist
}
