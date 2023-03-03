/*
 * In this ring list, an array is used for storing data, but its rear end is "attached" to its beginning so you get
 * a circular linear storage without a beginning or an end. The data structure is very similar to a ring buffer
 * (cf. https://en.wikipedia.org/wiki/Circular_buffer for useful visualisations). In a buffer, however, old data
 * gets overwritten when the buffer is full. In our case, on the other hand, we extend the size of the
 * ring storage array when it reaches its capacity, i.e. the storage is dynamic.
 * The ring structure is basically achieved by modulus operations (position % arrSize). We also need to know where
 * the data starts, which we use a variable 'offset' for. So the Item on position n is stored in 
 * array[(offset + n) % arrSize].
 */

public class DynamicRingList<Item> extends DynamicArrayList<Item> {
    protected int offset, arrSize;

    public DynamicRingList() {
        super();
        this.arrSize = 1;
        this.offset = 0;
    }

    @Override
    public void prepend(Item newItem) {
        size++;
        if (size > arrSize) {
            @SuppressWarnings("unchecked")
            Item[] newArray = (Item[]) new Object[arrSize * 2];
            for (int i = 0; i < size - 1; i++) {
                newArray[i + 1] = array[(offset + i) % arrSize];
            }
            array = newArray;
            arrSize = array.length;
            offset = 0;
        } else {
            offset--;
            offset = (offset + arrSize) % arrSize;
        }
        array[offset] = newItem;
    }

    @Override
    public void append(Item newItem) {
        size++;
        if (size > arrSize) {
            @SuppressWarnings("unchecked")
            Item[] newArray = (Item[]) new Object[arrSize * 2];
            for (int i = 0; i < size - 1; i++) {
                newArray[i] = array[(offset + i) % arrSize];
            }
            array = newArray;
            arrSize = array.length;
            offset = 0;
        }
        array[(offset + size - 1) % arrSize] = newItem;
    }


    @Override
    public Item removeFirst() {
        size--;
        Item removedItem = array[offset];
        array[offset] = null;
        if (size < array.length / 2) {
            @SuppressWarnings("unchecked")
            Item[] newArray = (Item[]) new Object[arrSize / 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[(offset + i + 1) % arrSize];
            }
            array = newArray;
            arrSize = array.length;
            offset = 0;
        } else {
            offset++;
            offset = offset % arrSize;
        }
        return removedItem;
    }

    @Override
    public Item removeLast() {
        size--;
        Item removedItem = array[(offset + size) % arrSize];
        array[(offset + size) % arrSize] = null;
        if (size < array.length / 2) {
            @SuppressWarnings("unchecked")
            Item[] newArray = (Item[]) new Object[arrSize / 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[(offset + i) % arrSize];
            }
            array = newArray;
            arrSize = array.length;
            offset = 0;
        }
        return removedItem;
    }

    @Override
    public String toString() {
        String string = "DynamicRingList: ";
        for (int i = 0; i < size; i++) {
            string = string + array[(offset + i) % arrSize].toString() + " ";
        }
        return string;
    }
}
