package Recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 1/5/2018.
 */
public class ParensTest {
    @Test
    public void testGenerateParenthesesSlowSolution() throws Exception {
        assertEquals(5, Parens.generateParentheses(3).size());
    }
}
