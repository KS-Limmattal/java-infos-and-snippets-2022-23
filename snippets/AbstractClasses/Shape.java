public abstract class Shape {
    private String name;

    // Konstruktor
    public Shape(String name) {
        this.name = name;
    }

    // abstrakte Methode (wird hier deklariert, aber nur in abgeleiteten Klassen
    // definiert)
    public abstract double getArea();

    // nicht-abstrakte Methode
    public String getName() {
        return this.name;
    }
}
