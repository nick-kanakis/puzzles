package Java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 30/5/2018.
 */
public class LambdaRandomTest {

    @Test
    public void testGetRandomSubset(){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        LambdaRandom.getRandomSubset(list);
    }
}
