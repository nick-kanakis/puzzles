package Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 27/5/2018.
 */
public class VolumeOfHistogramTest {
    @Test
    public void testCalculateHistogramVolume() throws Exception {
        int[] histogram = new int[]{0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0,3, 0, 0};
        assertEquals(46, VolumeOfHistogram.calculateHistogramVolume(histogram));
    }
}
