/*
 * Die LinkedList speichert die Elemente in sogenannten Nodes. Das n-te Element zu finden ist mühsamer als in einer 
 * ArrayList, da dafür alle n ersten Elemente durchlaufen werden müssen. Ist der zugehörige Node aber einmal gefunden, 
 * ist das Entfernen oder Einfügen danach sehr einfach - die next-Nodes werden einfach anders gesetzt 
 * (wer interessiert ist, findet eine allgemeine Lösung für insert() und remove() auskommentiert weiter unten).
 * 
 * In der vorliegenden Implementation arbeiten wir mit prepend(), append(), insertFirst() und insertLast(). 
 * Studiere diese Prozeduren und stelle sicher, dass du verstehst, was sie tun.
 * 
 * In LinkedList ist das Hinzufügen und Entfernen von Elementen am Anfang der Liste effizient, am Schluss hingegen
 * ineffizient. Das ist genau das Gegenteil von dem, was wir in einem Stack brauchen. Indem wir push() und pop() 
 * umdefinieren (Anfügen/ Entfernen am Anfang statt Schluss), wird LinkedList effizient als Stack nutzbar.
 */

import java.util.Iterator;

public class LinkedList<Item> extends List<Item> implements Iterable<Item> {
    protected Node first;

    protected class Node {
        Item item;
        Node next;

        protected Node(Item item){
            this(item, null);
        }

        protected Node(Item item, LinkedList<Item>.Node next) {
            this.item = item;
            this.next = next;
        }

        public String toString() {
            return this.item.toString();
        }
    }

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void prepend(Item newItem) {
        Node oldfirst = first;
        first = new Node(newItem, oldfirst);
        size++;
    }

    @Override
    public void append(Item newItem) {
        Node lastNode = first;
        Node newNode = new Node(newItem);
        if (lastNode == null) {
            first = newNode;
        } else  {
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
    }

    public Item removeFirst() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item removeLast() {
        Node node = first;
        for (int i = 0; i < size - 1; i++) {
            node = node.next;
        }
        node.next = null;
        size--;
        return node.item;
    }

    /*
     * Alternative way of implementing insert(position) and remove(position) instead
     */
    // private Node getNode(int position) {
    //     Node node = first;
    //     for (int i = 0; i < position; i++) {
    //         node = node.next;
    //     }
    //     return node;
    // }

    // @Override
    // public void insert(Item newItem, int position) {
    //     if (position <= size) {
    //         if (position == 0) {
    //             Node oldfirst = first;
    //             first = new Node(newItem, oldfirst);
    //         } else {
    //             Node nodeBefore = getNode(position - 1);
    //             Node newNode = new Node(newItem);
    //             newNode.next = nodeBefore.next;
    //             nodeBefore.next = newNode;
    //         }
    //         size++;
    //     }
    // }

    // @Override
    // public Item remove(int position) {
    //     Item item;
    //     if (position >= size) {
    //         return null;
    //     } else if (position == 0) {
    //         item = first.item;
    //         first = first.next;
    //     } else {
    //         Node nodeBefore = getNode(position);
    //         item = nodeBefore.next.item;
    //         nodeBefore.next = nodeBefore.next.next;
    //     }
    //     size--;
    //     return item;
    // }


    // Override push and pop because they are more efficient "the other way round".
    @Override
    public void push(Item item) {
        prepend(item);
    }  

    @Override
    public Item pop() {
        return removeFirst();
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }
        public void remove() {           
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // Could also be implemented without an iterator ("manually" jumping from one Node to its successor)
    public String toString() {
        String string = "LinkedList ";
        Iterator<Item> it = this.iterator();
        while (it.hasNext()) {
            string = string + it.next().toString() + " ";
        }
        return string;
    }
}