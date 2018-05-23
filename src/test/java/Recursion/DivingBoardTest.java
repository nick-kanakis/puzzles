package Recursion;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 22/5/2018.
 */
public class DivingBoardTest {

    @Test
    public void testDivingBoardsCombinations() throws Exception {
        List<Integer> sizes = DivingBoard.divingBoardsCombinations(5, 5, 10);

        //remove dups
        HashSet<Integer> set = new HashSet<>(sizes);

        assertEquals(sizes.size(), set.size());

        for (int size: sizes ) {
            assertTrue(size>=25 && size<=50 && size%5==0);
        }
    }
}
