package rit.stu.act1;

import rit.cs.Stack;

/**
 * A stack implementation that uses a Node to represent the structure.
 * @param <T> The type of data the stack will hold
 * @author RIT CS
 * @author YOUR NAME HERE
 */
public class StackNode<T> implements Stack<T> {

    /**
     * Create an empty stack.
     */
    public StackNode() {
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public void push(T element) {}

    @Override
    public T top() {
        return null;
    }
}
