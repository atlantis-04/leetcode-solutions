import java.util.*;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Enqueue: O(1)
    public void push(int x) {
        inStack.push(x);
    }

    // Dequeue: Amortized O(1)
    public int pop() {
        move();
        return outStack.pop();
    }

    // Peek front element
    public int peek() {
        move();
        return outStack.peek();
    }

    // Check if empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Helper: move elements only if outStack is empty
    private void move() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
