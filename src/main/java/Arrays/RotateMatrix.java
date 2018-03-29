package Arrays;

/**
 * Question:
 *  Given an image represented by NxN matrix, write a method to rotate the image by 90 degrees. Can you do it in place
 *
 * Mistakes:
 *  - You must not iterate as usual {0 TO N-1} since we rotate the elements iterate inside the 2 diagonals (main & anti)
 *  - Use start and end of the part you are working (start = main-diagonal, end = anti-diagonal)
 *  - At each swap one dimension stays the same (column or row)
 *  - Be very careful with the rotation of elements, specially in the inner layers!
 *
 */

public class RotateMatrix {

    public static int[][] rotate90InPlace(int[][] matrix) {
        int matrixSize = matrix.length;

        //iterate each layer
        for (int layer = 0; layer < matrixSize/2; layer++) {
            // first column/row of each layer (main diagonal)
            int first = layer;
            // last column/row of each layer (first half of anti-diagonal)
            int last = matrixSize - 1 - first;

            /*iterate from the starting column of this layer to the last column - 1 and swap the elements as shown below:
            *
            * temp = top
            * top = left
            * left = bottom
            * bottom = right
            * right = tmp
            *
            *
            */
            for (int i = first; i < last ; i++) {
                //offset from first column of each layer
                int offset = i - first;
                //Save top in tmp
                int tmp = matrix[first][i];

                //top = left
                matrix[first][i] = matrix[last - offset][first];

                // left = bottom
                matrix[last - offset][first] = matrix[last][last - offset];

                //bottom = right
                matrix[last][last - offset] = matrix[i][last];

                //right = tmp
                matrix[i][last] = tmp;
            }
        }
        return matrix;
    }
}
