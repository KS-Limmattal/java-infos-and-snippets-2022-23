public class Triangle extends Shape {
    // Die drei Seitenlängen
    private double a;
    private double b;
    private double c;

    // Konstruktor
    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Überschreibe abstrakte Methode
    @Override
    public double getArea() {
        double s = this.getPerimeter() / 2.;
        return Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
    }

    public double getPerimeter() { // Umfang
        return (this.a + this.b + this.c);
    }
}
