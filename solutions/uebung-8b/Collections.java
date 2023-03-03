/*
 * Das Java Collections Framework stellt unterschiedliche Listen- und Abbildungstypen bereits zur Verfügung.
 * In dieser Klasse werden einige davon ausprobiert.
 */

import java.util.*;

public class Collections {

    static void print(java.util.ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<String> list = new java.util.ArrayList<String>(); // creates an empty list of strings
        list.add("Agatha");  // adds to the end of the list
        list.add("Bert");
        list.add(1, "Constantin"); // inserts at index 1
        print(list);
        if (list.contains("Constantin")) {
            list.remove("Constantin");
        }
        list.set(0, "Ewa");
        print(list);
        System.out.println("");


    //     TreeSet<String> set = new TreeSet<String>();
    //     set.add("Hello");
    //     set.add("World");
    //     set.add("!");
    //     set.remove("Hello");
    //     for (String s: set) {
    //         System.out.println(s);
    //     }
    //     System.out.println("");


    //     HashMap<String, Integer> phoneBook = new HashMap<String, Integer>();
    //     phoneBook.put("Atwood", 123456);
    //     phoneBook.put("Krethi", 452317);
    //     phoneBook.put("Plethi", 876543);
    //     if (phoneBook.containsKey("Krethi")) {
    //         phoneBook.remove("Krethi");
    //     }
    //     for (String name: phoneBook.keySet()) {
    //         System.out.println(name + ": " + phoneBook.get(name));
    //     }
    }
}
