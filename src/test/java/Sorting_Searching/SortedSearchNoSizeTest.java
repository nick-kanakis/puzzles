package Sorting_Searching;

import Sorting_Searching.SortedSearchNoSizeQ.Listy;
import Sorting_Searching.SortedSearchNoSizeQ.SortedSearchNoSize;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 13/5/2018.
 */
public class SortedSearchNoSizeTest {

    @Test
    public void testSearch() throws Exception {
        Listy list = new Listy(200);
        assertEquals(123, SortedSearchNoSize.search(list, 246));
    }
}
