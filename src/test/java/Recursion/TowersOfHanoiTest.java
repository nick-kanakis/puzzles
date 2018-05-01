package Recursion;

import Recursion.TowersOfHanoi.Game;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 1/5/2018.
 */
public class TowersOfHanoiTest {
    @Test
    public void testMoveDisks() throws Exception {
        assertTrue(Game.moveDisks(5));
    }
}
