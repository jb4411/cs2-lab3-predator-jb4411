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
    private Node<T> queue;
    /**
     * Create an empty queue.
     */
    public QueueNode() {
        this.queue = null;
    }

    @Override
    public T back() {
        assert !empty();
        return null;
    }

    @Override
    public T dequeue() {
        assert !empty();
        return null;
    }

    @Override
    public boolean empty() {
        return this.queue == null;
    }

    @Override
    public void enqueue(T element) {

    }

    @Override
    public T front() {
        assert !empty();
        return null;
    }
}
