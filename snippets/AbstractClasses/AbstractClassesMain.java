/**
 * Eine abstrakte Klasse ist eine Basisklasse, welche nicht instanziert werden
 * kann, da nicht sämtliche Methoden definiert worden sind. Sie werden nur in
 * den abgeleiteten Klassen definiert. Die Basisklasse bleibt abstrakt (es gibt
 * keine Instanzen davon), während abgeleitete Klassen (in der Regel)
 * nicht-abstrakt sind (es können Instanzen davon gebildet werden)
 * 
 * Eine abstrakte Klasse "A" kann mit
 * 
 * "public abstract class A"
 * 
 * definiert werden.
 * Abstrakte Methoden (also solche, welche nicht definiert, sondern nur
 * deklariert werden), werden mit dem "abstract" Schlüsselwort eingeleitet
 * und haben keine geschweiften Klammern (und somit keine Definition), also wie
 * 
 * "public abstract <return type> f(<Parameters>);"
 * 
 * In einer nicht-abstrakten abgeleiteten Klasse muss dann eine Definition
 * stehen, eingeleitet mit der @Override-Annotation, wie
 * 
 * "@Override
 * public <return type> f(<Parameters>) {
 * // Code, der die Funktion definiert
 * }"
 * 
 * Die @Override-Annotation ist nicht zwingend notwendig. Sie sorgt aber dafür,
 * dass der Compiler meldet, wenn mit dieser Funktion der abgeleiteten Klasse
 * nicht wirklich eine Methode der Basisklasse überschrieben wird, etwa weil
 * die Parameterliste, der Rückgabetyp oder die Sichtbarkeit verschieden ist.
 * 
 * Theoretische braucht eine abstrakte Klasse keine abstrakten Methoden zu
 * enthalten. Sie kann auch einfach nur als unvollständig angesehen werden, so
 * dass sie nicht instanziert werden soll. Das ist aber eher die Ausnahme.
 * 
 * Ausserdem ist es möglich, dass eine abgeleitete Klasse einer abstrakten
 * Klasse ebenfalls abstrakt ist und dass nur eine ferner davon abgeleitete
 * Klasse nicht-abstrakt ist (instanziert werden kann)
 * Die abgeleitete abstrakte Klasse kann dabei bereits einige der abstrakten
 * Methoden definieren.
 * 
 * Obwohl eine abstrakte Klasse nicht instanziert werden kann, soll in ihnen
 * doch ein (odere mehrere) Konstruktor(en) definiert sein, die von den
 * abgeleiteten Klassen in ihren Konstruktoren aufgerufen werden können.
 */

public abstract class AbstractClassesMain {
    public static void main(String[] args) {
        Circle circle = new Circle("Kleiner Kreis", 0.02);
        Rectangle rectangle = new Rectangle("Fussballfeld", 105, 68);
        Square square = new Square("Schachbrettfeld", 0.08);
        Triangle triangle = new Triangle("Pythagoräisches Dreieck", 3, 4, 5);

        // Shape testShape = new Shape("Test-Form"); geht hingegen nicht, da Shape eine
        // abstrakte Klasse ist

        // Down-Casting ist aber möglich
        Shape triangleAsShape = triangle;
        System.out.println("Das Dreieck hat auch als Form den Namen " + triangleAsShape.getName());

        // Hier wird ein Array von Typ Shape erzeugt
        Shape[] shapes = { circle, rectangle, square, triangle };
        for (Shape shape : shapes) {
            System.out.println(shape.getName() + " hat Fläche " + shape.getArea());
        }
    }
}
