package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

/**
 * Implementation of a Stack (LIFO) using the provided DLinkList.
 * * @param <E> the type of elements held in this stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Pushes an element onto the top of this stack.
     * * @param x the element to be pushed onto the stack
     */
    @Override
    public void push(E x) {
        // We add at the beginning of the list to represent the top of the stack
        elems.addFirst(x);
    }

    /**
     * Removes and returns the element at the top of this stack.
     * * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elems.removeFirst();
    }

    /**
     * Retrieves, but does not remove, the element at the top of this stack.
     * * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        /* * Logic: Since DLinkList doesn't have a getFirst() method,
         * we pop it and push it back immediately to "peek" at it.
         */
        E top = elems.removeFirst();
        elems.addFirst(top);
        return top;
    }

    /**
     * Returns the number of elements currently in the stack.
     * * @return the total number of elements
     */
    @Override
    public int numOfElems() {
        // Since the 'size' field in DLinkList is private and there's no size() method,
        // we can derive it from the toString() or implement a size() method in DLinkList.
        // If you can modify DLinkList, adding 'public int size() { return size; }' is better.

        // Assuming you can add a size() method to DLinkList, otherwise this is a placeholder:
        return getListSize();
    }

    /**
     * Helper to check if the stack is empty.
     */
    public boolean isEmpty() {
        // If toString() returns "[]", the list is empty
        return "[]".equals(elems.toString());
    }

    /**
     * Fallback method to get size if DLinkList cannot be modified.
     */
    private int getListSize() {
        String s = elems.toString();
        if (s.equals("[]")) return 0;
        // Count commas + 1 (very basic way to get size from toString)
        return s.split(", ").length;
    }
}