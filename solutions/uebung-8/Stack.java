/*
 * Das mit Item parametrisierte interface Stack soll zwei Methoden deklarieren:
 * - "push", die ein Argument vom Typ Item entgegennimmt (keine Rückgabe)
 * - "pop", die das zuletzt hinzugefügte Item entfernt und zurückgibt
 */

public interface Stack<Item> {
    public void push(Item item);
    public Item pop();
}
