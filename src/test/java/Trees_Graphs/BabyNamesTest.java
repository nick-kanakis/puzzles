package Trees_Graphs;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 26/5/2018.
 */
public class BabyNamesTest {
    @Test
    public void testMerge() throws Exception {
        HashMap<String, Integer> names = new HashMap<>();
        names.put("john", 10);
        names.put("jon", 3);
        names.put("davis", 2);
        names.put("kari", 3);
        names.put("johnny", 11);
        names.put("carlton", 8);
        names.put("carleton", 2);
        names.put("jonathan", 9);
        names.put("carrie", 5);

        String[][] synonyms = new String[][]{
                {"jonathan","john"},
                {"jon","johnny"},
                {"johnny","john"},
                {"kari","carrie"},
                {"carleton","carlton"}
        };

        HashMap<String, Integer> result = BabyNames.merge(names, synonyms);

        assertEquals(new Integer(33), result.get("jon"));
        assertEquals(new Integer(8), result.get("carrie"));
        assertEquals(new Integer(2), result.get("davis"));
        assertEquals(new Integer(10), result.get("carlton"));
    }
}
