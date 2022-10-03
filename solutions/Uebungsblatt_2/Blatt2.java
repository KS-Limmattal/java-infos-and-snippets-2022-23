public class Blatt2 {
    public static void main(String[] args) {
        int[] a = { 2, 5, 7, 4, 11 };
        invert(a);
        for (int x : a) {
            System.out.print(x + " ");
        }

        System.out.println();
        int[] b = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0 };
        printMountain(b);
        int[][] array1 = { { 4, 3, 2 }, { 7, 1, 5 }, { 8, 6, 9 } };
        check3by3(array1);
        int[][] array2 = { { 4, 3, 2 }, { 7, 1, 6 }, { 8, 6, 9 } };
        check3by3(array2);

        int[][] array = { { 1, 5, 9, 7 }, { 2, 4, 3, 8 }, { 1, 9, 0, 8 } };
        printArray(array);
        printArray(transpose(array));

        poly(1.5, 3, 4, 0, -1);

        double[][] m = { { 0, 2, 3, 4 }, { 0, 6, 7, 8 }, { 6, 10, 17, 21 } };
        printArray(gaussJordan(m));
    }

    static void invert(int[] a) {
        int l = a.length;
        for (int i = 0; i < l / 2; i++) {
            int temp = a[i];
            a[i] = a[l - 1 - i];
            a[l - 1 - i] = temp;
        }
    }

    static void printMountain(int[] altitudes) {
        int l = altitudes.length;
        int max = 0;
        for (int x : altitudes) {
            if (x > max) {
                max = x;
            }
        }
        // simple version
        for (int h = max; h >= 0; h--) {
            String zeile = "";
            for (int i = 0; i < l; i++) {
                zeile += (altitudes[i] == h) ? "*" : " ";
            }
            System.out.println(zeile);
        }

        // more sophisticated version
        for (int h = max; h >= 0; h--) {
            String zeile = "";
            for (int i = 0; i < l; i++) {
                char c = ' ';
                if (altitudes[i] == h) {
                    if (i == l - 1) {
                        c = '\\'; // we assume it goes down at the very right
                    } else if (altitudes[i] < altitudes[i + 1]) {
                        c = '/';
                    } else if (altitudes[i] == altitudes[i + 1]) {
                        c = '-';
                    } else {
                        c = '\\';
                    }
                }
                zeile += c;
            }
            System.out.println(zeile);
        }
    }

    static void check3by3(int[][] a) {
        for (int i = 1; i <= 9; i++) {
            boolean found = false;
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (a[x][y] == i) {
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("missing: " + i);
                return;
            }
        }
        System.out.println("Found all digits");
    }

    static int[][] transpose(int[][] a) {
        int[][] b = new int[a[0].length][a.length];
        for (int y = 0; y < a[0].length; y++) {
            for (int x = 0; x < a.length; x++) {
                b[y][x] = a[x][y];
            }
        }
        return b;
    }

    static void printArray(int[][] a) {
        for (int x = 0; x < a.length; x++) {
            System.out.print("|");
            for (int y = 0; y < a[0].length; y++) {
                System.out.print(a[x][y]);
            }
            System.out.println("|");
        }
        System.out.println();
    }

    static void printArray(double[][] a) {
        for (int x = 0; x < a.length; x++) {
            System.out.print("|");
            for (int y = 0; y < a[0].length; y++) {
                System.out.print(Math.round(a[x][y] * 100) / 100.);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println();
    }

    static void poly(double x, double... c) { // e.g. poly(x,c2,c1,c0)
        double result = 0;
        int n = c.length;
        String s = "";
        assert (c[0] != 0); // note that the indexing is reversed
        for (int i = 0; i < n; i++) {
            String sep = (i == n - 1) ? "" : " + ";
            s += "" + c[i] + "*x^" + (n - 1 - i) + sep;
            result = result * x + c[i];
        }
        System.out.println("The polynomial is p(x) = " + s);
        System.out.println("The result for x = " + x + " is p(x) = " + result);
    }

    static double[][] gaussJordan(double[][] a) {
        printArray(a);
        int n = a[0].length;
        assert (n == a.length + 1); // n-1 rows according to exercise

        // echolon row form (Gauss)
        int i0 = 0; // index of the pivot row
        int j0 = 0; // index of the pivot column
        while (i0 < n - 1 && j0 < n) {
            // increase j0 until column is non-vanishing
            boolean vanishing = true;
            int iFirst = i0;
            for (int i = i0; i < n - 1; i++) {
                if (a[i][j0] != 0) {
                    vanishing = false;
                    iFirst = i;
                    break;
                }
            }
            if (vanishing) {
                j0++;
            } else {

                // swap i0-th and iFirst row if needed
                if (i0 != iFirst) {
                    for (int x = j0; x < n; x++) {
                        double tmp = a[iFirst][x];
                        a[iFirst][x] = a[i0][x];
                        a[i0][x] = tmp;
                    }
                }
                // subtract multiples of i0-th row from rows below
                for (int y = i0 + 1; y < n - 1; y++) {
                    double f = a[y][j0] / a[i0][j0];
                    a[y][j0] = 0;
                    for (int x = j0 + 1; x < n; x++) {
                        a[y][x] -= f * a[i0][x];
                    }
                }
                i0++;
                j0++;
            }
        }
        printArray(a);

        i0 = n - 2;
        j0 = n - 1;
        // reduced echolon row form (Jordan)
        while (i0 >= 0) {
            // decrease i0 until row is non-vanishing
            boolean vanishing = true;
            for (int j = 0; j < j0; j++) {
                if (a[i0][j] != 0) {
                    vanishing = false;
                    j0 = j;
                    break;
                }
            }
            if (vanishing) {
                i0--;
            } else {
                // scale row so that pivot is 1
                double s = 1 / a[i0][j0];
                a[i0][j0] = 1.;
                for (int x = j0 + 1; x < n; x++) {
                    a[i0][x] *= s;
                }
                // subtract multiples of the i0-th row from rows above
                for (int y = i0 - 1; y >= 0; y--) {
                    double f = a[y][j0] / a[i0][j0];
                    a[y][j0] = 0;
                    for (int x = j0 + 1; x < n; x++) {
                        a[y][x] -= f * a[i0][x];
                    }
                }
            }
            i0--;
        }
        printArray(a);
        double[][] sol = new double[n - 1][1];
        for (int y = 0; y < n - 1; y++) {
            sol[y][0] = a[y][n - 1];
        }
        return sol;
    }
}
