package Recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 1/5/2018.
 */
public class PermutationsTest {
    @Test
    public void testFindEveryPermutation() throws Exception {
        assertEquals(1, Permutations.findPermutation("aaaaaa").size());
        assertEquals(3, Permutations.findPermutation("aab").size());
        assertEquals(6, Permutations.findPermutation("aabb").size());
    }
}
