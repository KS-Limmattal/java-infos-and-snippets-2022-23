public class Vector2d {
    public double x;
    public double y;

    private static int numVectorsConstructed = 0;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
        numVectorsConstructed++;
    }

    public String toString() {
        return "Vektor (" + this.x + ", " + this.y + ")";
    }

    public static void printVectorsConstructed() {
        System.out.println("Bisher wurde(n) " + numVectorsConstructed + " Vektor(en) konstruiert. ");
    }

    public void runAction(Action a) {
        switch (a) {
            case PRINT:
                System.out.println(this);
                break;
            case TRIPLE:
                this.x *= 3;
                this.y *= 3;
                break;
            case INVERT:
                this.x *= -1;
                this.y *= -1;
                break;
            case NORMALIZE:
                double betrag = Math.sqrt(this.x * this.x + this.y * this.y);
                this.x /= betrag;
                this.y /= betrag;
                break;
        }
    }
}
