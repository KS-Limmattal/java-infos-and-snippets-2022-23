/*
 * Schreiben Sie eine Methode "even", welche ein zweidimensionales int-Array als Paramter hat
 * und das zweidimensionale boolean-Array zurückliefert, bei welchem jeder int aus dem Parameter
 * durch True bzw. False ersetzt wird, je nachdem ob dieser int gerade oder ungerade ist.
 * Rufen Sie die Methode "even" in der main-Methode mit dem int-array { {1, 2, 3}, {4, 5, 6} } auf
 * und schreiben Sie es mit Hilfe von print(Arrays.deepToString(meinArray)) auf die Konsole
 * Hinweis: das Ergebnis sollte { {false, true, false}, {true, false, true} } sein
 * 
 * 
 * Schreiben Sie eine Methode "collapse", welches ein zweidimensionales int-Array mit 6 Zeilen 
 * und 6 Spalten als Paramter hat und das zweidimensionale int-Array mit 3 Zeilen und 3 Spalten
 * zurückliefert, welches dadurch zu Stande kommt, dass der Parameter als 3x3 Block-Matrix
 * von 2x2 Blöcken aufgefasst wird und im Rückgabe-Wert jeder 2x2-Block 
 * { 
 * {a, b}, 
 * {c, d}
 * } 
 * durch die "Determinante" a*d-b*c ersetzt wird.
 * Rufen Sie die Methode "collapse" in der main-Methode mit dem int-array 
 * {
 * { 1, 2, 3, 4, 5, 6},
 * { 7, 6, 5, 4, 3, 2},
 * { 2, 3, 4, 5, 6, 7}, 
 * { 8, 7, 6, 5, 4, 3},
 * { 3, 4, 5, 6, 7, 8},
 * { 9, 8, 7, 6, 5, 4}
 * }
 * auf und schreiben Sie es mit Hilfe von print(Arrays.deepToString(meinArray)) auf die Konsole
 * 
 * Hinweis: das Ergebnis sollte das int-Array
 * {
 * { -8, -8, -8},
 * { -10, -10, -10},
 * { -12, -12, -12}
 * }
 * sein, denn zum Beispiel hat der 2x2 Block
 * {
 * {1, 2},
 * {7, 6}
 * }
 * Determinante 1*6-2*7 = -8, genauso wie der 2x2 Block 
 * { 
 * {3, 4}, 
 * {5, 4}
 * }
 * rechts davon.
 * 
 * Bonuspunkt: Schreiben Sie die Methode so, dass int-Arrays mit beliebiger geraden Zeilen- und
 * Spalten-Zahl als Parameter akzeptiert werden. Der Rückgabewert hat halb so viele Zeilen und
 * halb so viele Spalten wie der Parameter
 */

import java.util.Arrays; // Zum Debuggen print(Arrays.deepToString(...))

public class Aufgabe2 {
    public static void main(String args[]) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(Arrays.deepToString(even(a)));

        int[][] b = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 6, 5, 4, 3, 2 },
                { 2, 3, 4, 5, 6, 7 },
                { 8, 7, 6, 5, 4, 3 },
                { 3, 4, 5, 6, 7, 8 },
                { 9, 8, 7, 6, 5, 4 }
        };
        System.out.println(Arrays.deepToString(collapse(b)));
    }

    public static boolean[][] even(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        boolean[][] ret = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = (a[i][j] % 2 == 0);
            }
        }
        return ret;
    }

    public static int[][] collapse(int[][] b) {
        int m = b.length;
        int n = b[0].length;
        int[][] ret = new int[m / 2][n / 2];
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                ret[i][j] = b[2 * i][2 * i] * b[2 * i + 1][2 * i + 1] - b[2 * i + 1][2 * i] * b[2 * i][2 * i + 1];
            }
        }
        return ret;
    }
}