package lesson180717;

/**
 * Created by Daria on 18.07.2017.
 */
public class LinkedList<E> {

    static class Node<E> {
        E item;
        Node<E> next;
    }

    Node first;
    Node last;

    public void add(E item) {
        Node<E> node = new Node<>();
        node.item = item;
        node.next = null;

        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    public void print() {
        // traverse
        Node<E> current = first;

        while(current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }

}
