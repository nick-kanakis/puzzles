package General;

import General.helper.Pair;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 20/5/2018.
 */
public class NumberSwapperTest {

    @Test
    public void testSwapInPlace() throws Exception {

        Pair pair1 = new Pair(3, 7);
        Pair pair2 = new Pair(6, 2);
        Pair pair3 = new Pair(-3, -7);
        Pair pair4 = new Pair(-6, -2);
        Pair pair5 = new Pair(3, -2);
        Pair pair6 = new Pair(-3, 2);

        Pair result = NumberSwapper.swapInPlace(pair1);
        assertTrue(pair1.a == result.b && pair1.b == result.a);
        result = NumberSwapper.swapInPlace(pair2);
        assertTrue(pair2.a == result.b && pair2.b == result.a);
        result = NumberSwapper.swapInPlace(pair3);
        assertTrue(pair3.a == result.b && pair3.b == result.a);
        result = NumberSwapper.swapInPlace(pair4);
        assertTrue(pair4.a == result.b && pair4.b == result.a);
        result = NumberSwapper.swapInPlace(pair5);
        assertTrue(pair5.a == result.b && pair5.b == result.a);
        result = NumberSwapper.swapInPlace(pair6);
        assertTrue(pair6.a == result.b && pair6.b == result.a);

    }
}
