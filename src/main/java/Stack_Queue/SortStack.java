package Stack_Queue;

import Stack_Queue.helper.MyStack;

/**
 * Question:
 *  Write a program to sort a stack such that the smallest items are on the top. You can only use an additional temporary
 *  stack.
 *
 * Mistakes:
 *  - How would you solve it with 3 stacks. Can you eliminate the 1 stack?
 *  - When removing elements (pop) from the stack always check if stack is empty!
 *
 * Solution:
 *  Move elements from original to sorted stack as long as the previous element is greater than the current element.
 *  If current element is greater than the top of the sorted stack, move elements from sorted to original until the
 *  top of the sorted stack is greater than the current element. Repeat the algorithm until original is empty
 *
 */
public class SortStack {
    public static MyStack<Integer> sortStack(MyStack<Integer> originalStack) {
        MyStack<Integer> sortedStack = new MyStack<>();

        while(!originalStack.isEmpty()){
            int currentElement = originalStack.pop();
            if(sortedStack.isEmpty() || sortedStack.peek() >= currentElement){
                sortedStack.push(currentElement);
            } else {
                while(!sortedStack.isEmpty() && currentElement >= sortedStack.peek()){
                    originalStack.push(sortedStack.pop());
                }
                sortedStack.push(currentElement);
            }
        }
        return sortedStack;
    }
}
