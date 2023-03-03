/*
 * Die parametrisierte Klasse DynamicArrayList soll eine von ArrayList abgeleitete Klasse sein,
 * bei der aber das Array bereits "auf Vorrat" vergrössert bzw. verkleinert wird.
 * Das Array soll in der Grösse verdoppelt werden, wenn es zu klein ist,
 * und halbiert, wenn es zu weniger als der Hälfte gefüllt ist. 
 * Beachten Sie, dass "size" nun nur noch die Grösse der Liste angibt und nicht mehr die Grösse des Arrays!
 */

public class DynamicArrayList<Item> extends ArrayList<Item> {

    @SuppressWarnings("unchecked")
    public DynamicArrayList() {
        this.array = (Item[]) new Object[1]; // size 1 makes more sense since doubling an array of size 0 would cause problems
        this.size = 0;
    }

    /*
     * Implemented insert and remove instead of append/prepend and removeFirst/Last, but in a more efficient way
     * than in ArrayList: When operations are applied to the end of the array (or at least near its end), they are
     * considerably faster. Prepend and RemoveFirst, on the other hand, are still as slow as in ArrayList.
     */
    @Override
    public void insert(Item newItem, int position) {
        size++;
        if (size > array.length) {
            @SuppressWarnings("unchecked")
            Item[] newArray = (Item[]) new Object[array.length * 2];
            for (int i = 0; i < position; i++) {
                newArray[i] = array[i];
            }
            newArray[position] = newItem;
            for (int i = position + 1; i < size; i++) {
                newArray[i] = array[i - 1];
            }
            array = newArray;
        } else {
            for (int i = size - 1; i > position; i--) {
                array[i] = array[i - 1];
            }
            array[position] = newItem;
        };   
    }

    @Override
    public Item remove(int position) {
        size--;
        Item removedItem = array[position];
        if (size < array.length / 2) {
            @SuppressWarnings("unchecked")
            Item[] newArray = (Item[]) new Object[array.length / 2];
            for (int i = 0; i < position; i++) {
                newArray[i] = array[i];
            }
            for (int i = position; i < size; i++) {
                newArray[i] = array[i + 1];
            }
            array = newArray;
        } else {
            for (int i = position; i < size; i++) {
                array[i] = array[i + 1];
            }
        }
        return removedItem;
    }

    @Override
    public String toString() {
        return "Dynamic" + super.toString();
    }
}
