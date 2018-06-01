package Java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 30/5/2018.
 */
public class LambdaExpressionsTest {

    @Test
    public void testGetPopulation(){
        LambdaExpressions.Country c1 = new LambdaExpressions.Country("Europe", 10);
        LambdaExpressions.Country c2 = new LambdaExpressions.Country("Europe", 11);
        LambdaExpressions.Country c3 = new LambdaExpressions.Country("Africa", 10);
        LambdaExpressions.Country c4 = new LambdaExpressions.Country("Europe", 12);
        LambdaExpressions.Country c5 = new LambdaExpressions.Country("Europe", 13);
        LambdaExpressions.Country c6 = new LambdaExpressions.Country("America", 12);

        List<LambdaExpressions.Country> countries = Arrays.asList(c1,c2,c3,c4,c5,c6);

        assertEquals(48, LambdaExpressions.getPopulation(countries, "Europe"));
    }
}
