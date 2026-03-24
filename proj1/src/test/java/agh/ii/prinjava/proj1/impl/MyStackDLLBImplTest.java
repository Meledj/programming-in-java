package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link MyStackDLLBImpl} implementation.
 * Tests core stack operations: push, pop, peek, and size management.
 */
class MyStackDLLBImplTest {

    // Assuming MyStack.create() returns a new MyStackDLLBImpl<Integer>()
    private MyStack<Integer> stackOfInts;

    /**
     * Initializes a fresh stack before each test execution.
     */
    @BeforeEach
    void setUp() {
        stackOfInts = MyStack.create();
    }

    /**
     * Cleans up the stack reference after each test.
     */
    @AfterEach
    void tearDown() {
        stackOfInts = null;
    }

    /**
     * Tests that elements are correctly pushed onto the stack
     * and the count of elements increases accordingly.
     */
    @Test
    void push() {
        stackOfInts.push(10);
        stackOfInts.push(20);
        assertEquals(2, stackOfInts.numOfElems(), "Stack size should be 2 after two pushes.");
        assertEquals(20, stackOfInts.peek(), "The top element should be the last one pushed (20).");
    }

    /**
     * Tests the pop operation to ensure LIFO (Last-In, First-Out) order
     * and checks that it throws an exception when the stack is empty.
     */
    @Test
    void pop() {
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);

        assertEquals(3, stackOfInts.pop(), "First pop should return the last element pushed (3).");
        assertEquals(2, stackOfInts.pop(), "Second pop should return 2.");
        assertEquals(1, stackOfInts.pop(), "Third pop should return 1.");

        // Test exception on empty stack
        assertThrows(IllegalStateException.class, () -> stackOfInts.pop(),
                "Popping from an empty stack should throw IllegalStateException.");
    }

    /**
     * Tests the peek operation to ensure it returns the top element
     * without removing it from the stack.
     */
    @Test
    void peek() {
        stackOfInts.push(100);
        assertEquals(100, stackOfInts.peek(), "Peek should return 100.");
        assertEquals(1, stackOfInts.numOfElems(), "Peek should not remove the element.");

        // Test exception on empty stack
        MyStack<Integer> emptyStack = MyStack.create();
        assertThrows(IllegalStateException.class, () -> emptyStack.peek(),
                "Peeking into an empty stack should throw IllegalStateException.");
    }

    /**
     * Tests that the number of elements is tracked correctly
     * throughout multiple operations.
     */
    @Test
    void numOfElems() {
        assertEquals(0, stackOfInts.numOfElems(), "New stack should have 0 elements.");
        stackOfInts.push(5);
        stackOfInts.push(15);
        assertEquals(2, stackOfInts.numOfElems());
        stackOfInts.pop();
        assertEquals(1, stackOfInts.numOfElems());
    }

    /**
     * Tests the empty state logic.
     * Note: If your MyStack interface doesn't have isEmpty(),
     * this checks if numOfElems() returns 0.
     */
    @Test
    void isEmpty() {
        // Assuming isEmpty() is a logical check via numOfElems() == 0
        assertTrue(stackOfInts.numOfElems() == 0, "Stack should be empty initially.");
        stackOfInts.push(42);
        assertFalse(stackOfInts.numOfElems() == 0, "Stack should not be empty after a push.");
    }
}