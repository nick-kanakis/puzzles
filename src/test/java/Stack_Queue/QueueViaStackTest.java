package Stack_Queue;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 10/11/2017.
 */
public class QueueViaStackTest {

    @Test
    public void testMyQueue() throws Exception {
        QueueViaStack queue = new QueueViaStack();

        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.enqueue(2);
        assertEquals(1, queue.peek());
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
