package Recursion;

import java.util.Arrays;


/**
 * Question:
 *  Given a stack of n boxes with width, height and depth that can only be stack on top of each other (without rotations) but
 *  the box below must be bigger in all dimension. Implement a method to compute the tallest stack of boxes.
 *
 * Mistakes:
 *  > (int i = bottomIndex + 1; i <sortedBoxesByHeight.length ; i++) ... Search the boxes with greater height than our bottom
 *      (skip the bottom box)
 *  > maxHeight += bottomBox.height Add the bottom height at the very end of the function.
 *
 * Solution:
 *  1) Sort in Descending order all boxes
 *  2) Starting from the bottom select a box as the bottom box and find the max height of the stack we can create
 *     if we start with this box as a base
 *      2.1) We have the bottom box of our stack for each box ABOVE it check if it can be placed on top
 *           of the bottom box, if it can recursive call the function as a bottom box this box, if not move to the next
 *           box.
 *      2.2) Return the max height.
 */
public class StackOfBoxes {

    static class Box implements Comparable<Box>{
        int height = 0;
        int depth = 0;
        int width = 0;

        public Box(int height, int depth, int width) {
            this.height = height;
            this.depth = depth;
            this.width = width;
        }

        @Override
        public int compareTo(Box o) {
            if(height < o.height)
                return 1;
            if(height == o.height)
                return 0;
            return -1;
        }

        public boolean canBePlacedAbove(Box box){
            if(height<=box.height && depth<=box.depth && width<=box.width )
                return true;
            return false;
        }
    }

    public static int computeMaxHeightOfBoxes(Box[] boxes) {
        Arrays.sort(boxes);
        int maxHeight =  0;

        for (int startingBoxIndex = 0; startingBoxIndex < boxes.length; startingBoxIndex++) {
            int tmpMaxHeight = maxHeightStartingAtBox(startingBoxIndex, boxes);
            if (tmpMaxHeight > maxHeight)
                maxHeight = tmpMaxHeight;
        }

        return maxHeight;
    }

    private static int maxHeightStartingAtBox(int bottomIndex, Box[] sortedBoxesByHeight){
        int maxHeight = 0;
        Box bottomBox = sortedBoxesByHeight[bottomIndex];

        for (int i = bottomIndex + 1; i <sortedBoxesByHeight.length ; i++) {
            if(sortedBoxesByHeight[i].canBePlacedAbove(bottomBox)){
                int height = maxHeightStartingAtBox(i, sortedBoxesByHeight);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += bottomBox.height;
        return maxHeight;
    }
}
