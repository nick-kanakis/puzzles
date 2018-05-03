package Recursion;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 2/5/2018.
 */
public class EightQueensTest {

    @Test
    public void testCountQueensPossiblePositions() throws Exception {
        ArrayList<Integer[]> results = new ArrayList<>();
        EightQueens.placeQueens(0, new Integer[8], results);
        assertEquals(92, results.size());
    }
}
