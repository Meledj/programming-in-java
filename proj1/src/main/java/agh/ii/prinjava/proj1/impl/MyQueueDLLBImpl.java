package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

/**
 * Implementation of the {@link MyQueue} interface based on a doubly linked list ({@link DLinkList}).
 * This implementation follows the FIFO (First-In-First-Out) principle.
 *
 * @param <E> the type of elements held in this queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private final DLinkList<E> elems = new DLinkList<>();

    /**
     * Adds an element to the end (rear) of the queue.
     *
     * @param x the element to be added
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element removed from the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public E dequeue() {
        if (numOfElems() == 0) {
            throw new IllegalStateException("Cannot dequeue from an empty queue");
        }
        return elems.removeFirst();
    }

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return the size of the queue
     */
    @Override
    public int numOfElems() {
        // Since DLinkList.size is private and has no getter in your snippet,
        // we'll use toString or assume a size() method exists.
        // If you can edit DLinkList, adding 'public int size() { return size; }' is best.
        // For this implementation, I'll assume you add that getter.
        return elems.size();
    }

    /**
     * Retrieves, but does not remove, the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public E peek() {
        if (numOfElems() == 0) {
            throw new IllegalStateException("Cannot peek into an empty queue");
        }
        // To peek without modifying DLinkList, we remove and immediately put back.
        // Alternatively, adding a getFirst() method to DLinkList would be much cleaner.
        E firstElem = elems.removeFirst();
        elems.addFirst(firstElem);
        return firstElem;
    }
}