package rit.stu.act1;

import rit.cs.Node;
import rit.cs.Queue;

import java.util.List;

/**
 * A queue implementation that uses a Node to represent the structure.
 * @param <T> The type of data the queue will hold
 * @author RIT CS
 * @author YOUR NAME HERE
 */
public class QueueNode<T> implements Queue<T> {
    private Node<T> back;
    private Node<T> front;
    /**
     * Create an empty queue.
     */
    public QueueNode() {
        this.back = null;
        this.front = null;
    }

    /**
     * Get the last element in the queue.
     *
     * @rit.pre: queue must not be empty
     * @throws AssertionError if queue empty
     * @return the back element
     */
    @Override
    public T back() {
        assert !empty();
        return this.back.getData();
    }

    /**
     * Remove and return the front element in the queue.
     *
     * @rit.pre: queue must not be empty
     * @throws AssertionError if queue empty
     * @return the front element
     */
    @Override
    public T dequeue() {
        assert !empty();
        T removed = this.front.getData();
        this.front = this.front.getNext();
        if (empty()) {
            this.back = null;
        }
        return removed;
    }

    /**
     * Check if the queue is currently empty or not.
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty() {
        return this.front == null;
    }

    /**
     * Add a new element to the back of the queue.
     *
     * @param element The new data element
     */
    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element,null);
        if (empty()) {
            this.front = newNode;
        } else {
            this.back.setNext(newNode);
        }
        this.back = newNode;
        }

    /**
     * Get the front element in the queue.
     *
     * @rit.pre: queue must not be empty
     * @throws AssertionError if queue empty
     * @return the front element
     */
    @Override
    public T front() {
        assert !empty();
        return this.front.getData();
    }
}
