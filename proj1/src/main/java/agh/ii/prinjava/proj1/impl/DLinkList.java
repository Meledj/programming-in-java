package agh.ii.prinjava.proj1.impl;

/**
 * A generic implementation of a doubly linked list.
 *
 * @param <E> the type of elements held in this collection
 */
public class DLinkList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    /**
     * Internal node storage unit containing the element and links to neighbors.
     * @param <T> the type of the element
     */
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    // --- Méthodes ---

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(e, null, f);
        first = newNode;
        if (f == null) {
            last = newNode; // The list was empty
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, l, null);
        last = newNode;
        if (l == null) {
            first = newNode; // The list was empty
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element of the list, or {@code null} if the list is empty
     */
    public E removeFirst() {
        if (first == null) return null;
        E element = first.elem;
        Node<E> next = first.next;

        first.elem = null; // Help Garbage Collector
        first.next = null;

        first = next;
        if (next == null) {
            last = null; // The list became empty
        } else {
            next.prev = null;
        }
        size--;
        return element;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element of the list, or {@code null} if the list is empty
     */
    public E removeLast() {
        if (last == null) return null;
        E element = last.elem;
        Node<E> prev = last.prev;

        last.elem = null;
        last.prev = null;

        last = prev;
        if (prev == null) {
            first = null; // The list became empty
        } else {
            prev.next = null;
        }
        size--;
        return element;
    }
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of the list.
     * The string consists of the elements enclosed in square brackets ("[]"),
     * separated by commas and spaces.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.elem);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }
}