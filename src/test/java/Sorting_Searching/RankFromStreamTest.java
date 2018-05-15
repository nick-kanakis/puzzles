package Sorting_Searching;

import Sorting_Searching.RankFromStream.RankFromStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 14/5/2018.
 */
public class RankFromStreamTest {
    @Test
    public void testRankFromStream() throws Exception {
        List<Integer> stream = new ArrayList<>();

        stream.add(5);
        stream.add(1);
        stream.add(4);
        stream.add(4);
        stream.add(5);
        stream.add(9);
        stream.add(7);
        stream.add(13);
        stream.add(3);
        stream.add(13);

        for (Integer integer : stream) {
            RankFromStream.track(integer);
        }

        assertEquals(8, RankFromStream.getRankOfNumber(9));
        assertEquals(10, RankFromStream.getRankOfNumber(13));
        assertEquals(6, RankFromStream.getRankOfNumber(5));
        assertEquals(4, RankFromStream.getRankOfNumber(4));
        assertEquals(2, RankFromStream.getRankOfNumber(3));

    }
}
