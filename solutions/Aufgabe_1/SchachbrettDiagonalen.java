public class SchachbrettDiagonalen {
    /*
     * Aufgabe: Gib alle Diagonalen des Schachbretts (wie a1-b2-c3-d4-e5-f6-g7-h8
     * oder h7-g8) aus
     */

    static final int N = 8; // Anzahl Linien und Reihen des Schachbretts

    public static void main(String[] args) {

        for (int i = 1; i < N; i++) {
            String d1 = ""; // Diagonale von a1, a2, ..., a7 aus nach rechts oben
            String d2 = ""; // Diagonale von h1, h2, ..., h7 aus nach links oben
            String d3 = ""; // Diagonale von b1, c1, ..., g1 aus nach rechts oben (nur für i > 1)
            String d4 = ""; // Diagonale von g1, f1, ....,b1 aus nach links oben (nur für i > 1)

            int l = N - i + 1; // Diagonalenlänge
            for (int j = 0; j < l; j++) {
                String sep = (j < l - 1) ? "-" : "";
                d1 += squareName(1 + j, i + j) + sep;
                d2 += squareName(N - j, i + j) + sep;
                if (i > 1) {
                    d3 += squareName(i + j, 1 + j) + sep;
                    d4 += squareName(N - i + 1 - j, 1 + j) + sep;
                }
            }

            System.out.println(d1);
            System.out.println(d2);
            if (i > 1) {
                System.out.println(d3);
                System.out.println(d4);
            }
        }
    }

    static String squareName(int x, int y) {
        char file = (char) ('a' + x - 1);
        return file + "" + y;
    }
}
