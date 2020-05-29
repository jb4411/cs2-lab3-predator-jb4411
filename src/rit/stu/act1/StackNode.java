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

    @Override
    public boolean empty() {
        return this.stackTop == null;
    }

    @Override
    public T pop() {
        assert ! this.empty();
        T oldTop = this.stackTop.getData();
        this.stackTop = this.stackTop.getNext();
        return oldTop;
    }

    @Override
    public void push(T element) {
        this.stackTop = new Node<T>(element, this.stackTop);
    }

    @Override
    public T top() {
        assert ! this.empty();
        return this.stackTop.getData();
    }
}
