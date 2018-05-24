package General;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 23/5/2018.
 */
public class PatternMatchingTest {

    @Test
    public void testPatternMatching() throws Exception {
        assertTrue(PatternMatching.patternMatching("aabab", "CATCATGOCATGO"));
        assertTrue(PatternMatching.patternMatching("a", "CATCATGOCATGO"));
        assertTrue(PatternMatching.patternMatching("b", "CATCATGOCATGO"));
        assertTrue(PatternMatching.patternMatching("ab", "CATCATGOCATGO"));
        assertFalse(PatternMatching.patternMatching("aabab", "CATCATGOICATGO"));
        assertFalse(PatternMatching.patternMatching("aabab", "CATTCATTGOCATGO"));
    }
}
