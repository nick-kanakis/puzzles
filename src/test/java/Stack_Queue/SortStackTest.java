package Stack_Queue;

import Stack_Queue.helper.MyStack;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 10/11/2017.
 */
public class SortStackTest {

    @Test
    public void testSortStack() throws Exception {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(10);
        stack.push(8);
        stack.push(7);
        stack.push(9);
        stack.push(6);

        MyStack<Integer> sortedStack = SortStack.sortStack(stack);

        for (int i = 1; i <= 10; i++) {
            assertEquals(i, sortedStack.pop().intValue());
        }
    }
}
