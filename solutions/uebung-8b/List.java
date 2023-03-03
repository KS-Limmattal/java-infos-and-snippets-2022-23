/*
 * Die abstrakte Klasse List erlaubt es, verschiedene Listentypen gleich zu behandeln.
 * Die vorgegebenen Prozeduren sind grösstenteils Platzhalterprozeduren. Wegen der statischen Typisierung in Java
 * müssen sie bereits den korrekten Ausgabetyp haben und geben deshalb im Wesentlichen sinnlose Rückgaben.
 * Diese Prozeduren dürfen (müssen zum Teil) in den abgeleiteten Klassen überschrieben werden.
 */

public abstract class List<Item> implements Stack<Item>, Queue<Item> {
    protected int size;

    public List() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

    /*
     * Operations to insert new values
     */
    public void prepend(Item item) {
        insert(item, 0);
    }

    public void append(Item item) {
        insert(item, getSize());
    }

    public void insert(Item item, int position) {}


    /*
     * Operations to remove values
     */
    public Item removeFirst() {
        return remove(0);
    }

    public Item removeLast() {
        return remove(getSize() - 1);
    }

    public Item remove(int position) {return null;}


    /*
     * Operations go get values without removing them
     */
    public Item get(int position) {return null;}


    /*
     * Operations for the interfaces Stack and Queue
     */
    @Override
    public void push(Item item) {
        append(item);
    }

    @Override
    public Item pop() {
        return removeLast();
    }

    @Override
    public void queue(Item item) {
        append(item);
    }

    @Override
    public Item dequeue() {
        return removeFirst();
    }
}
