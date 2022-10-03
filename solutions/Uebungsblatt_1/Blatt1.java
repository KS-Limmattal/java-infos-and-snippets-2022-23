public class Blatt1 {
    public static void main(String[] args) {
        distance(1, 3, 2, -4);

        round100(150);
        round100(349);
        round100(678);

        time(1234);

        checkTriple(1, 2, 3);
        checkTriple(5, 7, 7);
        checkTriple(-4, -4, -4);

        classifyTriangle(4, 3, 5);
        classifyTriangle(8, 8, 8);
        classifyTriangle(4, 5, 6);
        classifyTriangle(2, 3, 18);

        sortTriple(1, 2, 2);
        sortTriple(3, 5, 1);
        sortTriple(4, 1, 5);
        sortTriple(2, 3, 5);
        sortTriple(14, 11, 5);
        sortTriple(14, 5, 7);

        checkOverflow(1000, 1000);
        checkOverflow(1234567890, 1234567890);

        lineIntersection(1, 3, 1, 5, 2, 3, 5, 3);

        numberDigits(237);

        digitSum(4711);

        primeFactors(252);

        long startTimeIt = System.nanoTime();
        System.out.println("Iteratively: fib(42) = " + fibIt(42));
        long endTimeIt = System.nanoTime();
        long startTimeRec = System.nanoTime();
        System.out.println("Recursively: fib(42) = " + fibRec(42));
        long endTimeRec = System.nanoTime();
        System.out.println(
                "Iteratively it took " + (endTimeIt - startTimeIt) / 1000 + " microseconds, recursively it took "
                        + (endTimeRec - startTimeRec) / 1000 + " microseconds");

        System.out.println("Iteratively: binom(15,7) = " + binomIt(15, 7));
        System.out.println("Recursively: binom(15,7) = " + binomRec(15, 7));

        String s = "Anaconda";
        System.out.println("The string " + s + " reversed: " + mirrorString(s));
    }

    static void distance(int x1, int y1, int x2, int y2) {
        int result = (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        System.out.println(
                "The distance between (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") is roughly " + result);
    }

    static void round100(int x) {
        System.out.println("The integer x = " + x + " rounded on multiples of 100 is " + ((x + 50) / 100) * 100);
    }

    static void time(int sec) {
        int min = sec / 60;
        int hours = min / 60;
        int minLeft = min - hours * 60;
        int secLeft = sec - minLeft * 60 - hours * 60 * 60;
        System.out.println("" + sec + " seconds is " + hours + ":" + minLeft + ":" + secLeft);
    }

    static void checkTriple(int x, int y, int z) {
        System.out.println("Triple: x = " + x + ", y = " + y + ", z = " + z);
        if (x == y && y == z) {
            System.out.println("All values are equal");
        } else if (x != y && x != z && y != z) {
            System.out.println("All values are different");
        }
        if (x == y || x == z || y == z) {
            System.out.println("At least two values are equal");
        }
    }

    static void classifyTriangle(int a, int b, int c) {
        assert (a > 0 && b > 0 && c > 0);
        boolean rightAngled = (c * c == a * a + b * b || a * a == b * b + c * c || b * b == a * a + c * c);
        System.out.println("Side lengths: a = " + a + ", b = " + b + ", c = " + c);
        if (a == b && b == c) {
            System.out.println("Equilateral triangle");
        } else if (a == b || a == c || b == c) {
            if (!rightAngled) {
                System.out.println("Isosceles triangle");
            } else {
                System.out.println("Right angled isosceles triangle");
            }
        } else if (rightAngled) {
            System.out.println("Right angled triangle");
        } else if (a < b + c && b < a + c && c < a + b) {
            System.out.println("Valid triangle");
        } else {
            System.out.println("Invalid triangle");
        }
    }

    static void sortTriple(int a, int b, int c) {
        System.out.println("Triple: a = " + a + ", b = " + b + ", c = " + c);
        if (a >= b) {
            if (b >= c) {
                assert (a >= b && b >= c);
                System.out.println("Sorted: " + a + " >= " + b + " >= " + c);
            } else if (a >= c) {
                assert (a >= c && c > b);
                System.out.println("Sorted: " + a + " >= " + c + " >= " + b);
            } else {
                assert (c > a && a >= b);
                System.out.println("Sorted: " + c + " >= " + a + " >= " + b);
            }
        } else {
            assert (b > a);
            if (a >= c) {
                assert (b > a && a >= c);
                System.out.println("Sorted: " + b + " >= " + a + " >= " + c);
            } else if (b >= c) {
                assert (b >= c && c >= a);
                System.out.println("Sorted: " + b + " >= " + c + " >= " + a);
            } else {
                assert (c > b && b > a);
                System.out.println("Sorted: " + c + " >= " + b + " >= " + a);
            }
        }
    }

    static void checkOverflow(int a, int b) {
        long c = (long) a + (long) b;
        int d = a + b;
        if (c > Integer.MAX_VALUE) {
            System.out.println("Overflow, " + a + " + " + b + " > " + Integer.MAX_VALUE);
        } else if (c < Integer.MIN_VALUE) {
            System.out.println("Underflow, " + a + " + " + b + " < " + Integer.MIN_VALUE);
        } else {
            assert ((int) (c) == d);
            System.out.println("" + a + " + " + b + " = " + d);
        }
    }

    static void lineIntersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        boolean horizontal1 = (y1 == y2);
        boolean horizontal2 = (y3 == y4);
        boolean vertical1 = (x1 == x2);
        boolean vertical2 = (x3 == x4);
        boolean intersects = false;
        int xMin1 = Math.min(x1, x2);
        int xMax1 = Math.min(x1, x2);
        int xMin2 = Math.min(x3, x4);
        int xMax2 = Math.min(x3, x4);
        int yMin1 = Math.min(y1, y2);
        int yMax1 = Math.min(y1, y2);
        int yMin2 = Math.min(y3, y4);
        int yMax2 = Math.min(y3, y4);

        if (horizontal1 && horizontal2) {
            if (y1 == y3 && xMax1 >= xMin1 && xMax2 >= xMin2) {
                intersects = true;
            }
        } else if (vertical1 && vertical2) {
            if (x1 == x3 && yMax1 >= yMin1 && yMax2 >= yMin2) {
                intersects = true;
            }
        } else if (horizontal1 && vertical2) {
            if (xMin1 <= x3 && xMax1 >= x3) {
                intersects = true;
            }
        } else if (vertical1 && horizontal2) {
            if (yMin1 <= y3 && yMax1 >= y3) {
                intersects = true;
            }
        } else {
            System.out.println("Lines are neither horizontal nor vertical");
            return;
        }
        if (intersects) {
            System.out.println("The lines do intersect");
        } else {
            System.out.println("The lines do not intersect");
        }
    }

    static void numberDigits(int x) {
        int xOrig = x;
        int n = 0;
        while (x > 0) {
            x /= 10;
            n++;
        }
        System.out.println("The number " + xOrig + " has " + n + " digits. ");
    }

    static void digitSum(int x) {
        int xOrig = x;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        System.out.println("The number " + xOrig + " has digit sum " + sum);
    }

    static void primeFactors(int n) {
        int nOrig = n;
        String divisors = "";
        int dCurr = 2;
        while (n > 1) {
            // Find the smallest divisor and divide by it
            int x = dCurr;
            while (x <= n) {
                if (n % x == 0) {
                    String sep = (n == nOrig) ? "" : ", ";
                    n = n / x;
                    dCurr = x;
                    divisors += sep + dCurr;
                    break;
                } else {
                    x++;
                }
            }
        }
        System.out.println("The divisors of " + nOrig + " are " + divisors);
    }

    static int fibIt(int n) { // linear running time
        int f1 = 1;
        int f2 = 1;
        for (int i = 0; i <= n - 2; i++) {
            int f2Old = f2;
            f2 = f1 + f2;
            f1 = f2Old;
        }
        return f2;
    }

    static int fibRec(int n) { // exponential running time
        if (n == 0 || n == 1) {
            return 1;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    static int binomIt(int n, int k) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        for (int i = 1; i <= k; i++) {
            result /= i;
        }
        for (int i = 1; i <= n - k; i++) {
            result /= i;
        }
        return (int) result;
    }

    static int binomRec(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (k > n) {
            return 0;
        }
        return binomRec(n - 1, k - 1) + binomRec(n - 1, k);
    }

    static String mirrorString(String s) {
        if (s.length() == 0) {
            return "";
        }
        return mirrorString(s.substring(1)) + s.charAt(0);
    }
}
