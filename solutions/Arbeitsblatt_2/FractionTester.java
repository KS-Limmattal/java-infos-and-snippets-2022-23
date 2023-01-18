public class FractionTester {
    public static void main(String[] args) {
        Fraction f = new Fraction(1, 2);
        Fraction g = new Fraction(1, 3);
        Fraction h = Fraction.add(f, g);
        //f.add(g);
        System.out.println(Fraction.add(f, g)); // [1/2]
        System.out.println(f);
        System.out.println(Fraction.numberOfFractions);
    }

}
