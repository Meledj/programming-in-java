package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

/**
 * Interface representing a Queue data structure (FIFO - First In, First Out).
 *
 * @param <E> the type of elements maintained by this queue.
 */
public interface MyQueue<E> {

    /**
     * Inserts an element at the end of the queue.
     * @param x the element to be added to the queue.
     */
    void enqueue(E x);

    /**
     * Removes and returns the element at the front of the queue.
     * @return the element removed from the front.
     */
    E dequeue();

    /**
     * Checks if the queue contains no elements.
     * @return true if the queue is empty, false otherwise.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the current number of elements in the queue.
     * @return the size of the queue.
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the element at the front of the queue.
     * @return the element at the front of the queue.
     */
    E peek();

    /**
     * Factory method to create a new instance of MyQueue.
     * <p>
     * <b>Pros:</b> Encapsulates the concrete implementation, simplifies instantiation for the user.
     * <b>Cons:</b> Couples the interface to a specific implementation (MyQueueDLLBImpl).
     * </p>
     * @param <T> the type of elements for the new queue.
     * @return a new instance of MyQueue.
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}