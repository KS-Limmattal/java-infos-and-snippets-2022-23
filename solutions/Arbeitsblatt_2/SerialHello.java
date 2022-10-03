public class SerialHello {
    public static void main(String[] args) {
        // String[] names = { "Anna", "Bello", "Cara", "Delta" };
        for (int i = 0; i < args.length; i++) {
            System.out.println("Hello " + args[i] + "!");
        }
    }
}