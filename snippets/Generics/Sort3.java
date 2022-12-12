public class Sort3<T extends Comparable<T>> { // T muss das Interface Comparable mit Typargument T implementieren, d.h.
                                              // vergleichbar mit T sein
    private T obj1;
    private T obj2;

    public Sort3(T obj1, T obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void sort() {
        if (obj1.compareTo(obj2) > 0) { // obj1 ist grösser als obj2
            T tmp = obj1;
            obj1 = obj2;
            obj2 = tmp;
        }
    }

    public String toString() {
        return obj1 + " <= " + obj2;
    }
}