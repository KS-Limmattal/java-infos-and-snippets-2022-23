/*
 * Das mit Item parametrisierte interface Queue soll zwei Methoden deklarieren:
 * - "queue", die ein Argument vom Typ Item entgegennimmt (keine Rückgabe)
 * - "dequeue", die das schon am längsten in der Queue wartende Item entfernt und zurückgibt
 */

 public interface Queue<Item> {
    public void queue(Item item);
    public Item dequeue();
}
