package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

/**
 * Interface representing a Stack data structure (LIFO - Last In, First Out).
 *
 * @param <E> the type of elements maintained by this stack.
 */
public interface MyStack<E> {

    /**
     * Removes and returns the element at the top of the stack.
     * @return the element removed from the top.
     */
    E pop();

    /**
     * Pushes an element onto the top of the stack.
     * @param x the element to be pushed onto the stack.
     */
    void push(E x);

    /**
     * Checks if the stack contains no elements.
     * @return true if the stack is empty, false otherwise.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the current number of elements in the stack.
     * @return the size of the stack.
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the element at the top of the stack.
     * @return the element at the top of the stack.
     */
    E peek();

    /**
     * Factory method to create a new instance of MyStack.
     * <p>
     * <b>Pros:</b> Encapsulates the concrete implementation, simplifies instantiation for the user.
     * <b>Cons:</b> Couples the interface to a specific implementation (MyStackDLLBImpl).
     * </p>
     * @param <T> the type of elements for the new stack.
     * @return a new instance of MyStack.
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}