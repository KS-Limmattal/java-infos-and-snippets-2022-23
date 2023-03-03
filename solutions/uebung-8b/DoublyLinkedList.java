/*
 * Die doppelt verlinkte Liste funktioniert wie die verlinkte Liste, aber in beide Richtungen: Es kann auch der letzte 
 * Node direkt angesteuert werden (über die Variable last), und über previous kann auch rückwärts durch die Liste 
 * gegangen werden.
 * 
 * Die vorliegende DoublyLinkedList ist nicht von LinkedList abgeleitet, sondern direkt von List, da sich verschachtelte 
 * Klassen in abgeleiteten Klassen komplex verhalten.
 */

public class DoublyLinkedList<Item> extends List<Item> {
    protected Node first, last;

    protected class Node {
        Item item;
        Node previous, next;

        protected Node(Item item){
            this(item, null, null);
        }

        protected Node(Item item, Node previous, Node next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
            // System.out.println("New " + this.toStringWithPreviousAndNext());
        }

        public String toString() {
            return this.item.toString();
        }

        // for testing purposes
        protected String toStringWithPreviousAndNext() {
            return "Node[" + (previous == null ? "⌀" : previous.toString()) + " _"
                + this.toString() + "_ " + (this.next == null ? "⌀" : this.next.toString()) + "]";
        }
    }

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void append(Item newItem) {
        Node oldLast = last;
        last = new Node(newItem, oldLast, null);
        if (size == 0) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public void prepend(Item newItem) {
        Node oldFirst = first;
        first = new Node(newItem, null, oldFirst);
        if (size == 0) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
        size++;
    }


    @Override
    public Item removeFirst() {
        Item item = first.item;
        first = first.next;
        if (first != null) {
            first.previous = null;
        } else {
            assert size == 1;
            last = null;
        }
        size--;
        return item;
    }

    @Override
    public Item removeLast() {
        Item item = last.item;
        last = last.previous;
        if (last != null) {
            last.next = null;
        } else {
            assert size == 1;
            first = null;
        }
        size--;
        return item;
    }

    
    @Override
    public String toString() {
        String string = "DoublyLinkedList";
        Node node = first;
        for (int i = 0; i < size; i++) {
            string = string + " " + node.toString();
            node = node.next;
        }
        assert (node == null);
        return string;
    }
    
}
