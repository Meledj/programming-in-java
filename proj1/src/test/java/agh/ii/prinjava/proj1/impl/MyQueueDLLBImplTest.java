package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link MyQueueDLLBImpl} implementation.
 * These tests verify the core functionality of the FIFO queue: enqueue, dequeue, peek, and size management.
 */
class MyQueueDLLBImplTest {
    private MyQueue<Integer> queueOfInts;

    /**
     * Initializes a new queue instance before each test execution.
     */
    @BeforeEach
    void setUp() {
        queueOfInts = new MyQueueDLLBImpl<>();
    }

    /**
     * Cleans up resources after each test (optional in this case).
     */
    @AfterEach
    void tearDown() {
        queueOfInts = null;
    }

    /**
     * Tests that elements are correctly added to the queue and the size increases.
     */
    @Test
    void enqueue() {
        queueOfInts.enqueue(10);
        queueOfInts.enqueue(20);
        assertEquals(2, queueOfInts.numOfElems(), "Queue size should be 2 after two enqueues");
    }

    /**
     * Tests that elements are removed in FIFO (First-In-First-Out) order.
     * Also verifies that an exception is thrown when dequeuing from an empty queue.
     */
    @Test
    void dequeue() {
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);

        assertEquals(1, queueOfInts.dequeue(), "First element dequeued should be the first one enqueued (1)");
        assertEquals(1, queueOfInts.numOfElems(), "Queue size should be 1 after one dequeue");
        assertEquals(2, queueOfInts.dequeue(), "Second element dequeued should be 2");

        // Error case
        assertThrows(IllegalStateException.class, () -> queueOfInts.dequeue(),
                "Should throw IllegalStateException when dequeuing from an empty queue");
    }

    /**
     * Tests that the number of elements is accurately tracked.
     */
    @Test
    void numOfElems() {
        assertEquals(0, queueOfInts.numOfElems(), "New queue should be empty");
        queueOfInts.enqueue(100);
        assertEquals(1, queueOfInts.numOfElems());
        queueOfInts.dequeue();
        assertEquals(0, queueOfInts.numOfElems());
    }

    /**
     * Tests that peek returns the front element without removing it.
     */
    @Test
    void peek() {
        queueOfInts.enqueue(55);
        queueOfInts.enqueue(66);

        assertEquals(55, queueOfInts.peek(), "Peek should return the first element (55)");
        assertEquals(2, queueOfInts.numOfElems(), "Peek should not change the size of the queue");

        // Verify it still returns the same element
        assertEquals(55, queueOfInts.peek());
    }
}