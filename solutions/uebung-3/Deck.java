import java.util.Random;
import java.util.Arrays;

/**
 * Diese Klasse repräsentiert einen Kartenstapel mit einer variablen Anzahl
 * Karten
 * Sie soll ein Array von Typ Card als Instanzvariable haben,
 * - einen Konstruktor Deck(Card[] cards), welches eine Instanz bestehend aus
 * den gegebenen Karten kreiert,
 * - einen Konstruktor Deck(), welcher ein vollständiges Kartenset (4x9 Karten)
 * erzeugt,
 * - einen (trivialen) Getter getCards()
 * - eine Methode addCard(Card card), welche zum Deck eine Karte hinzufügt,
 * falls diese noch nicht im Deck enthalten ist und andernfalls eine Warnung auf
 * der Konsole ausgibt
 * - eine Methode pop(), welche die letzte Karte im Array aus dem Deck entfernt,
 * sofern Karten vorhanden sind
 * - eine Methode shuffle(), welche die Karten im Array durchmischt
 * 
 * Tipps:
 * - Um ein Array zu redimensionieren, verwende den Befehl "Arrays.copyOf" aus
 * java.util.Arrays
 * - Um eine zufällige Ganzzahl in einem gegebenen Bereich zu erzeugen, verwende
 * "rnd.nextInt", wobei "rnd" eine Instanz der Klasse "Random" aus
 * "java.util.Random" bezeichnet
 *
 */
public class Deck {
    private Card[] cards;

    public Deck(Card[] cards) {
        this.cards = cards;
    }

    public Deck() {
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        this.cards = new Card[ranks.length * suits.length];
        int count = 0;
        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                this.cards[count++] = new Card(suit, rank);
            }
        }
    }

    public Card[] getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        boolean contained = false;
        for (Card c : this.cards) {
            if (c.equals(card)) {
                contained = true;
                System.out.println("Karte " + card + " ist schon im Deck");
                return;
            }
        }
        if (!contained) {
            int n = this.cards.length;
            this.cards = Arrays.copyOf(this.cards, n + 1);
            this.cards[n] = card;
        }
    }

    public Card pop() {
        int n = this.cards.length;
        if (n == 0) {
            System.out.println("Keine Karte im Deck");
            return null;
        }
        Card last = this.cards[n - 1];
        this.cards = Arrays.copyOf(this.cards, n - 1); // Entfernt letzte Karte
        assert (this.cards.length == n - 1);
        return last;
    }

    public void shuffle() {
        Random rnd = new Random();
        for (int i = this.cards.length; i > 1; i--) {
            int newPos = rnd.nextInt(i); // zufällige Ganzzahl in [0, i-1]
            // Vertausche Karten mit Indizes i und newPos
            Card tmp = this.cards[i - 1];
            this.cards[i - 1] = this.cards[newPos];
            this.cards[newPos] = tmp;
        }
    }
}
