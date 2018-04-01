package Stack_Queue;

import Stack_Queue.helper.MyStack;

/**
 * Question:
 *  Implement a queue by using only 2 stacks.
 *
 * Mistakes:
 *
 * Solution:
 *  newElementsStack is used to store elements that are inserted to the queue. When we need to dequeue/peek the queue, we
 *  always use oldElementsStack. If stack2 is empty we push everything from newElementsStack --> oldElementsStack. If oldElementsStack
 *  is not empty (from a previous shift of elements) we just pop/peek the top element.
 */
public class QueueViaStack {
    MyStack<Integer> newElementsStack = new MyStack<>();
    MyStack<Integer> oldElementsStack = new MyStack<>();

    public boolean isEmpty() {
        if(newElementsStack.isEmpty() && oldElementsStack.isEmpty())
            return true;
        return false;
    }

    public void enqueue(int i) {
        newElementsStack.push(i);
    }

    public int peek() {
        if(oldElementsStack.isEmpty()){
            moveElements(newElementsStack, oldElementsStack);
        }
        return oldElementsStack.peek();
    }

    public int dequeue() {
        if(oldElementsStack.isEmpty()){
            moveElements(newElementsStack, oldElementsStack);
        }
       return oldElementsStack.pop();
    }

    private void moveElements(MyStack<Integer> stack1, MyStack<Integer> stack2) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}
