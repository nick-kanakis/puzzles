package Stack_Queue;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StackMinTest {
    @Test
    public void testStackWithMin() throws Exception {
        StackMin stack = new StackMin();

        stack.push(10);
        stack.push(50);
        stack.push(5);
        stack.push(4);

        assertEquals(4, stack.min());
        assertEquals(4, stack.pop());
        assertEquals(5, stack.min());
        assertEquals(5, stack.pop());
        assertEquals(10, stack.min());

        stack.push(1);
        stack.push(2);
        assertEquals(1, stack.min());
        assertEquals(2, stack.pop());
    }

}
