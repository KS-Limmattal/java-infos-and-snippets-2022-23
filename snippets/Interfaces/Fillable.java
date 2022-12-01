public interface Fillable {
    int MAX_REFILLS = 100; // automatisch "public static final"

    void fillUp(); // automatisch "public abstract"

    void empty(); // automatisch "public abstract"

    boolean isEmpty(); // automatisch "public abstract"
}
