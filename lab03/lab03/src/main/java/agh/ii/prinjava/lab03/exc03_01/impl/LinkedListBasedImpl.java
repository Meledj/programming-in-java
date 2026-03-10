package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

/**
 * Implementation of the {@link QueueOfInts} interface using a doubly linked list.
 *
 * The queue stores integers and supports insertion at the front and
 * removal from the end of the structure.
 *
 * This implementation maintains references to the first and last nodes
 * to allow constant time enqueue and dequeue operations.
 */
public class LinkedListBasedImpl implements QueueOfInts {

    /** Reference to the first node in the queue. */
    private Node first = null;

    /** Reference to the last node in the queue. */
    private Node last = null;

    /** Number of elements currently stored in the queue. */
    private int numOfElems = 0;

    /**
     * Inserts an integer element into the queue.
     *
     * @param x the integer value to add to the queue
     * @throws IllegalStateException if the queue structure becomes inconsistent
     * @throws RuntimeException if an unexpected error occurs during insertion
     */
    @Override
    public void enqueue(int x) {
        try {
            Node cur = this.first;

            if (cur == null) {
                this.first = new Node(x);
                this.last = this.first;
            } else {
                cur = new Node(x, this.first, null);

                if (this.first == null) {
                    throw new IllegalStateException("Queue state is inconsistent: first node is null");
                }

                this.first.prev = cur;
                this.first = cur;
            }

        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Memory allocation failed while enqueuing element: " + x, e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error during enqueue operation", e);
        }
    }

    /**
     * Removes and returns the element at the end of the queue.
     *
     * @return the integer value removed from the queue
     * @throws IllegalStateException if the queue is empty
     * @throws RuntimeException if an unexpected error occurs during removal
     */
    @Override
    public int dequeue() {
        try {

            if (this.last == null) {
                throw new IllegalStateException("Cannot dequeue from an empty queue");
            }

            int value = this.last.elem;
            Node prev = this.last.prev;

            if (prev == null) {
                this.first = null;
                this.last = null;
            } else {
                this.last.prev = null;
                prev.next = null;
                this.last = prev;
            }

            return value;

        } catch (Exception e) {
            throw new RuntimeException("Unexpected error during dequeue operation", e);
        }
    }

    /**
     * Returns the number of elements currently stored in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * Returns the next element that would be removed from the queue
     * without removing it.
     *
     * @return the next element in the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public int peek() {
        throw new IllegalStateException("To be implemented");
    }

    /**
     * Internal node representation used in the doubly linked list.
     * Each node stores an integer value and references to the
     * previous and next nodes.
     */
    private static class Node {

        /** Stored integer value. */
        int elem;

        /** Reference to the next node in the list. */
        Node next;

        /** Reference to the previous node in the list. */
        Node prev;

        /**
         * Creates a node containing the given value.
         *
         * @param elem the integer value stored in the node
         */
        public Node(int elem) {
            this.elem = elem;
        }

        /**
         * Creates a node with full linkage information.
         *
         * @param elem the integer value stored in the node
         * @param next reference to the next node
         * @param prev reference to the previous node
         */
        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }
}