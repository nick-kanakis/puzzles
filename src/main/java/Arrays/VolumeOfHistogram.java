package Arrays;

/**
 * (CTCI Q17.20) Question:
 *   Imagine a histogram. Design an algorithm to compute the volume of water it could hold if someone
 *   poured water across the top, you can assume the histogram bar has width of 1 (page 189 CTCI)
 *
 * Mistakes:
 *  -
 * Solution:
 *  1) Start from left to right and track the max height you have seen so far
 *  2) Start from right to left and track the max height you have seen so far
 *  3) For each position in the 3 created array do the following:
 *      3.1) Compute the min value of arrays created by step 1 & 2
 *      3.2) Subtract the result fo the histogram array from the result of 3.1 and store it on the diff array
 *  4) sum all values of the diff array.
 */
public class VolumeOfHistogram {
    public static int calculateHistogramVolume(int[] histogram) {

        int [] maxLeftToRight = maxLeftToRight(histogram);
        int [] maxRightToLeft = maxRightToLeft(histogram);

        int [] diff = calculateDiff(histogram, maxLeftToRight, maxRightToLeft);

        return sumOfArray(diff);
    }

    private static int[] maxLeftToRight(int[] histogram) {
        int[] maxLeftToRight = new int[histogram.length];

        int maxSoFar = -1;
        for (int i = 0; i <histogram.length; i++) {
            if(histogram[i] > maxSoFar){
                maxSoFar = histogram[i];
            }
            maxLeftToRight[i] = maxSoFar;
        }

        return maxLeftToRight;
    }

    private static int[] maxRightToLeft(int[] histogram) {
        int[] maxRightToLeft = new int[histogram.length];

        int maxSoFar = -1;
        for (int i = histogram.length -1; i >=0 ; i--) {
            if(histogram[i] > maxSoFar){
                maxSoFar = histogram[i];
            }
            maxRightToLeft[i] = maxSoFar;
        }

        return maxRightToLeft;
    }

    private static int[] calculateDiff(int[] histogram, int[] maxLeftToRight, int[] maxRightToLeft) {
        int[] diff = new int[histogram.length];

        for (int i = 0; i < histogram.length; i++) {
            diff[i] = Math.min(maxLeftToRight[i], maxRightToLeft[i]) - histogram[i];
        }
        return diff;
    }

    private static int sumOfArray(int[] diff) {
        int sum = 0;

        for (int value : diff) {
            sum += value;
        }
        return sum;
    }

}
