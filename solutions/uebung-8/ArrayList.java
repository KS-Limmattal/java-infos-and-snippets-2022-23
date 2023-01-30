/*
 * Die Klasse ArrayList soll vom generischen Typ Item sein und von der Klasse "List" abgeleitet.
 * Als Felder hat sie ein Item-Array, das die Daten speichert, sowie einen Integer "size", das ihre Grösse speichert.
 * Ein parameterloser Konstruktor soll ein leeres Array und eine size von 0 initialisieren.
 * Implementieren Sie die Prozedur "toString", das die Inhalte des Daten-Arrays in einen sinnvollen String umwandelt
 * (Code-Recycling!).
 * 
 * Implementieren Sie entweder die Methoden "prepend" und "append" oder aber eine Methode "insert"
 * (auf die die parent-Methoden prepend und append zugreifen können).
 * Testen Sie in der ListTester-Klasse, ob die Methoden das tun, was sie sollen. 
 * 
 * Ebenso implementieren Sie entweder "removeFirst" und "removeLast" oder "remove".
 * Sie dürfen weitere Prozeduren aus der Klasse "List" überschreiben, falls Sie sie brauchen wollen.
 */

public class ArrayList<Item> extends List<Item> {
    protected Item[] array;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.array = (Item[]) new Object[0];
        this.size = 0;
    }

    @Override
    public void insert(Item newItem, int position) {
        size++;
        @SuppressWarnings("unchecked")
        Item[] newArray = (Item[]) new Object[size];
        for (int i = 0; i < position; i++) {
            newArray[i] = array[i];
        }
        newArray[position] = newItem;
        for (int i = position + 1; i < size; i++) {
            newArray[i] = array[i - 1];
        }
        array = newArray;
    }

    @Override
    public Item remove(int position) {
        size--;
        @SuppressWarnings("unchecked")
        Item[] newArray = (Item[]) new Object[size];
        for (int i = 0; i < position; i++) {
            newArray[i] = array[i];
        }
        Item removedItem = array[position];
        for (int i = position; i < size; i++) {
            newArray[i] = array[i + 1];
        }
        array = newArray;
        return removedItem;
    }

    @Override
    public Item get(int position) {
        return array[position];
    }

    @Override
    public String toString() {
        /*
         * Alternatively,
         // Arrays.toString(array);
         * would work, but then the method would need to be re-written for DynamicArrayList.
         */
        String string = "ArrayList: ";
        for (int i = 0; i < size; i++) {
            string = string + array[i].toString() + " ";
        }
        return string;
    }


}
