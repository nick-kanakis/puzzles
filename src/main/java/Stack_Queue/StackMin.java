package Stack_Queue;

import Stack_Queue.helper.MyStack;

import java.util.Stack;

/**
 * Question:
 *  How would you design a stack which, in addition to push & pop has a min function that which returns the minimum element.
 *  Push/Pop/Min should all operate in O(1)
 *
 * Mistakes:
 *
 * Solution:
 *  Use an additional stack to keep track of the min. When push is called if the secondary stack's top element is bigger
 *  that the new element insert it there as well. When pop is called the popped element is removed and from the secondary stack
 *  (if it is at the top).
 */
public class StackMin {
    MyStack<Integer> primaryStack = new MyStack<>();
    MyStack<Integer> minStack = new MyStack<>();

    public void push(int i) {
        if (minStack.isEmpty() || minStack.peek() > i){
            minStack.push(i);
        }
        primaryStack.push(i);
    }

    public int min() {
        return minStack.peek();
    }

    public int pop() {
        int popped = primaryStack.pop();
        if(!minStack.isEmpty() && popped == minStack.peek()){
            minStack.pop();
        }
        return popped;
    }
}
