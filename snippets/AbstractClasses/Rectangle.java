public class Rectangle extends Shape {
    double width;
    double height;

    // Konstruktor
    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    // Überschriebene abstrakte Methode
    @Override
    public double getArea() {
        return this.width * this.height;
    }

}
