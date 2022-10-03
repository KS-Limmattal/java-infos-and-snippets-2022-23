public class Powers {
    public static void main(String[] args) {
        int base = Integer.parseInt(args[0]);
        int exponent = Integer.parseInt(args[1]);
        System.out.println("For base " + base + " the square is " + square(base) + " and the cube is " + cube(base));
        System.out.println("For base " + base + " and exponent " + exponent + " the power is " + power(base, exponent));
    }

    static int square(int base) {
        return base * base;
    }

    static int cube(int base) {
        if (base > 1290) {
            System.out.println("Warning: The cube of " + base + " is outside of the range of int. ");
        } else if (base == 0 || base == 1) {
            System.out.println("useless operation, but ok");
        } else {
            System.out.println("Nothing to worry about :-)");
        }
        return base * base * base;
    }

    static int power(int base, int n) {
        int power = 1;
        for (int i = 0; i < n; i++) {
            power = power * base;
        }
        return power;
    }
}
