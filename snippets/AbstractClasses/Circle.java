public class Circle extends Shape {
    private double radius;

    // Konstruktor
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    // Überschriebene abstrakte Methode
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}
