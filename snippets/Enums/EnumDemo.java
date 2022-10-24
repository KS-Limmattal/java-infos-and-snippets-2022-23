public class EnumDemo {
    /**
     * Demonstriert das enum Spielerposition (aus Spielerposition.java)
     */
    public static void main(String[] args) {
        Spielerposition position1 = Spielerposition.VERTEIDIGER; // Erzeugung eines Objekts
        Spielerposition position2 = Spielerposition.valueOf("VERTEIDIGER"); // selbes Resultat
        // Ein Unterschied besteht jedoch darin, dass in der ersten Variante ein
        // Tippfehler bereits beim Kompilieren entdeckt wird.

        for (Spielerposition pos : Spielerposition.values()) { // Iteration durch alle Objekte des enums
            System.out.println("Spielerposition " + pos.name() + " mit Nummer " + pos.ordinal());
            if (pos.equals(position1)) {
                System.out.println("Das war nun die Verteidigerposition!");
            }
        }
    }
}
