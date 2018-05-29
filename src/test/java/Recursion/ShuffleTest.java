package Recursion;

import Recursion.Shuffle;
import org.junit.Test;

/**
 * Created by Nicolas on 25/5/2018.
 */
public class ShuffleTest {
    @Test
    public void testShuffleCards() throws Exception {
        int[] deck = new int[]{1,2,3,4,5,6,7,8};
        /*Not really a test just validating that the execution will not fail*/
        Shuffle.shuffleCards(deck);


    }
}
