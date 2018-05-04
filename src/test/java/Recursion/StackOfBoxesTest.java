package Recursion;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 4/5/2018.
 */
public class StackOfBoxesTest {

    @Test
    public void testComputeMaxHeightOfBoxes() throws Exception {
        StackOfBoxes.Box box1 = new StackOfBoxes.Box(15, 12, 17);
        StackOfBoxes.Box box2 = new StackOfBoxes.Box(14, 15, 15);
        StackOfBoxes.Box box3 = new StackOfBoxes.Box(13, 11, 14);
        StackOfBoxes.Box box4 = new StackOfBoxes.Box(12, 10, 18);
        StackOfBoxes.Box box5 = new StackOfBoxes.Box(16, 12, 20);

       StackOfBoxes.Box[] boxes = new StackOfBoxes.Box[5];
        boxes[0] = box1;
        boxes[1] = box2;
        boxes[2] = box3;
        boxes[3] = box4;
        boxes[4] = box5;

        assertEquals(44, StackOfBoxes.computeMaxHeightOfBoxes(boxes));
        assertEquals(44, StackOfBoxes.computeMaxHeightOfBoxes(boxes));
    }
}
