package agh.ii.prinjava.lab03.exc03_01;

/**
 * Represents a queue storing integers.
 *
 * A queue follows the FIFO (First-In-First-Out) principle where
 * elements are added using {@code enqueue} and removed using {@code dequeue}.
 */
public interface QueueOfInts {

    /**
     * Inserts an integer element into the queue.
     *
     * @param x the integer value to add to the queue
     * @throws IllegalStateException if the queue cannot accept new elements
     */
    void enqueue(int x);

    /**
     * Removes and returns the element at the end of the queue.
     *
     * @return the integer value removed from the queue
     * @throws IllegalStateException if the queue is empty
     */
    int dequeue();

    /**
     * Checks whether the queue contains any elements.
     *
     * @return {@code true} if the queue contains no elements, {@code false} otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements currently stored in the queue.
     *
     * @return the number of elements in the queue
     */
    int numOfElems();

    /**
     * Returns the next element that would be removed from the queue
     * without removing it.
     *
     * @return the next element in the queue
     * @throws IllegalStateException if the queue is empty
     */
    int peek();
}