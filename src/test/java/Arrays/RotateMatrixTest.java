package Arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 28/3/2018.
 */
public class RotateMatrixTest {

    @Test
    public void testRotate90InPlace() throws Exception {
        int[][] matrix ={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] expected ={{21,16,11,6,1},{22,17,12,7,2},{23,18,13,8,3},{24,19,14,9,4},{25,20,15,10,5}};
        int[][] result = RotateMatrix.rotate90InPlace(matrix);

        assertTrue(Arrays.deepEquals(expected, result));
    }
}
