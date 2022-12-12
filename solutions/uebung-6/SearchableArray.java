/*
 * Die Klasse "SearchableArray" soll die Interfaces Searchable und Addable auf Basis eines Arrays implementieren
 * 
 * Sie enthält folgende Instanzvariablen:
 * - "stringArray" (Array von Zeichenketten)
 * - "capacity" (aktuelle Grösse des Arrays)
 * - "size" (wie viele Zeichenketten im Array gespeichert sind)
 * 
 * Der Konstruktor soll "capacity" und "stringArray" (angepasst auf die richtige Grösse) übernehmen und "size"
 * so definieren, dass es mit der Anzahl der in der Instanzvariablen "stringArray" gespeicherten Zeichenketten, 
 * die aus dem Parameterwert "stringArray" stammen, übereinstimmt.
 * 
 * Die "search" und "countOccurences"-Methoden sollen das tun, was im Interface "Searchable" vorgegeben ist
 * Die add-Methode soll eine Zeichenkette zum Array hinzufügen. Genügt die Kapazität des Arrays nicht, 
 * so soll diese jeweils verdoppelt werden
 */


import java.util.Arrays;

public class SearchableArray implements Searchable, Addable {
    private String[] stringArray;
    private int capacity; // wird als >0 angenommen
    private int size;

    public SearchableArray(String[] stringArray, int capacity) {
        assert (capacity > 0);
        this.capacity = capacity;
        this.size = stringArray.length;
        this.stringArray = Arrays.copyOf(stringArray, capacity);
        if (this.size > this.stringArray.length) {
            this.size = stringArray.length;
        }
    }

    @Override // von Addable
    public void add(String string) {
        if (this.size >= this.capacity) {
            this.capacity *= 2;
            this.stringArray = Arrays.copyOf(stringArray, capacity);
        }
        assert (this.size < this.capacity);
        stringArray[size++] = string;
    }

    @Override // von Searchable
    public boolean search(String searchString) {
        for (String str : stringArray) {
            if (str.equals(searchString)) {
                return true;
            }
        }
        return false;
    }

    @Override // von Searchable
    public int countOccurences(String searchString) {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (stringArray[i].equals(searchString)) {
                count++;
            }
            if (count == MAX_COUNT) {
                return MAX_COUNT;
            }
        }
        return count;
    }
}
