package Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 26/5/2018.
 */
public class MajorityElementTest {
    @Test
    public void testFindMajorityElement() throws Exception {
        int[] arrayWithMajority = new int[]{1,5,5,5,5,5,7};
        assertEquals(5, MajorityElement.findMajorityElement(arrayWithMajority));
    }

    @Test
    public void testFindMajorityWithNoMajority() throws Exception {
        int[] arrayWithNoMajority = new int[]{1,2,3,4,5,6,7,8};
        assertEquals(-1, MajorityElement.findMajorityElement(arrayWithNoMajority));
    }

    @Test
    public void testFindMajorityWithCandidateButNotMajority() throws Exception {
        int[] arrayWithCandidateButNotMajority = new int[]{1,2,3,4,5,6,7,7,7};
        assertEquals(-1, MajorityElement.findMajorityElement(arrayWithCandidateButNotMajority));
    }
}
