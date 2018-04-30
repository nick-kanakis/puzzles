package Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 30/4/2018.
 */
public class PowerSetTest {
    @Test
    public void testGetPowerSet(){
        ArrayList<String> input = new ArrayList<>();
        input.add("a");
        input.add("b");
        input.add("c");

        ArrayList<String> powerSet = PowerSet.getPowerSet(input);
        assertEquals(8, powerSet.size());
    }
}
