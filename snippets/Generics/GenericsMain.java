/*
 * Ein "parametrisierter Typ" (auf Englisch: "Generic") ist ein Typbezeichner in einer Methode oder Klasse, 
 * der durch eine Variable (z.B. "T") repräsentiert wird, und erst bei der Verwendung der Methode/Klasse 
 * mit einem konkreten Typ zu einer uns bekannten Methode oder Klasse wird.  
 * Die Typvariable wird jeweils durch spitze Klammern <T> spezifiziert. 

 * 
 * 1) Parameterisierter Typ in einer Methode: 
 * 
 * Die Typvariable muss vor dem Rückgabetyp spezifiziert werden:
 * 
 * public static <T> void printMatrix(T[][] mat) {
 *     // Code zur Ausgabe einer Matrix von Typ T auf der Konsole
 * }
 * 
 * Ist nun etwa "mat" ein zweidimensionales Integer-Array, so ruft 
 * "printMatrix(mat)" eine Methode der Form
 * "public static void printMatrix(Integer[][] mat)" auf. 
 * 
 *  
 * 2) Parametrisierter Typ in einer Klasse:
 * 
 * Hier wird die Typvariable nach dem Klassennamen spezifiziert:
 * 
 * public class Test<T> {
 *     T obj;
 *     public Test(T obj) {
 *        this.obj = obj;
 *     }
 *     public T getObject() {
 *        return this.obj;
 *     }
 * }
 * 
 * Eine Instanz der Klasse Test mit Typargument "String" wird dann
 * etwa so angelegt:
 *  * 
 * Test<String> test = new Test<String>("Hallo");
 * 
 * 
 * Es ist zu beachten, dass das Typargument immer für eine Klasse steht, 
 * nicht für einen primitiven Datentyp. Statt "int" muss also z.B. die
 * Wrapper-Klasse "Integer" verwendet werden.
 * 
 * Soll die Typvariable auf Klassen eingeschränkt werden, die von einer
 * gewissen Basisklasse "Base" abgeleitet werden oder ein gewisses Interface "IFace"
 * implementieren, so lässt sich das in der
 * spitzen Klammer durch <T extends Base> bzw. <T extends IFace> angeben.
 * Beachte, dass hier auch für Interfaces "extends" und nicht "implements" verwendet wird.
 * 
 */

public class GenericsMain {
    public static void main(String[] args) {
        Integer[][] intMatrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        printMatrix(intMatrix); // verwendet "printMatrix" mit Typargument "Integer"
        System.out.println();

        Double[][] dblMatrix = { { 3.141, 2.718 }, { 23.14, 0.693 } };
        printMatrix(dblMatrix); // verwendet "printMatrix" mit Typargument "Double"
        System.out.println();

        Test<String> testStr = new Test<String>("Hallo"); // Objekt der Klasse Test mit Typargument "String"
        System.out.println(testStr.getObject());

        Test<Integer> testInt = new Test<Integer>(42); // Objekt der Klasse Test mit Typargument "Integer"
        System.out.println(testInt.getObject());

        Sort3<Integer> sort3Int = new Sort3<Integer>(5, 3);
        sort3Int.sort();
        System.out.println(sort3Int);

        Sort3<String> sort3String = new Sort3<String>("Omega", "Alpha");
        sort3String.sort();
        System.out.println(sort3String);

    }

    public static <T> void printMatrix(T[][] mat) { // generische Methode
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String sep = j < n - 1 ? " " : "";
                System.out.print(mat[i][j] + sep);
            }
            System.out.println();
        }
    }
}
