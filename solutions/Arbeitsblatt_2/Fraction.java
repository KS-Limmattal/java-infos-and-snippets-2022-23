public class Fraction {
    static int numberOfFractions;
    private int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.setDenominator(denominator);
        numberOfFractions++;
    }

    public Fraction(Fraction f) {
        this(f.numerator, f.denominator);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        } else {
            this.denominator = denominator;
        }
    }

    public void add(Fraction f) {
        this.setNumerator(this.numerator * f.denominator + this.denominator * f.numerator);
        this.setDenominator(this.denominator * f.denominator);
    }

    public static Fraction add(Fraction f, Fraction g) {
        f.add(g);
        return f;
    }

    public boolean equals(Fraction f) {
        return this.numerator * f.denominator == this.denominator * f.numerator;
    }

    @Override
    public String toString() {
        return "[" + numerator + "/" + denominator + "]";
    }

}
