package rit.stu.act1;

import rit.cs.Stack;
import rit.cs.Node;

/**
 * A stack implementation that uses a Node to represent the structure.
 * @param <T> The type of data the stack will hold
 * @author RIT CS
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class StackNode<T> implements Stack<T> {
    Node<T> stackTop;
    /**
     * Create an empty stack.
     */
    public StackNode() {
        this.stackTop = null;
    }

    /**
     * Check if the stack is currently empty or not.
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty() {
        return this.stackTop == null;
    }

    /**
     * Remove and return the top element in the stack.
     *
     * @rit.pre: stack must not be empty
     * @throws AssertionError if stack empty
     * @return the front element
     */
    @Override
    public T pop() {
        assert !empty();
        T oldTop = this.stackTop.getData();
        this.stackTop = this.stackTop.getNext();
        return oldTop;
    }

    /**
     * Add a new element to the top of the stack.
     *
     * @param element The new data element
     */
    @Override
    public void push(T element) {
        this.stackTop = new Node<T>(element, this.stackTop);
    }

    /**
     * Get the top element on the stack.
     *
     * @rit.pre: stack must not be empty
     * @throws AssertionError if stack empty
     * @return The top element
     */
    @Override
    public T top() {
        assert !empty();
        return this.stackTop.getData();
    }
}
