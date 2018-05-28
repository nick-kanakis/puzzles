package Recursion.RobotInAGrid;

import javafx.geometry.Pos;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * (CTCI 8.2) Question:
 *  A robot sits on the upper left corner of a grid with r rows & c columns. The robot moves down & right, certain
 *  cells are off limits. Design an algorithm to find a path for the robot from top left to bottom right.
 *
 * Mistakes:
 *  > When we trace back our steps delete from the path list each position we are until we can move to a new unvisted
 *    position.
 *
 * Solution:
 *  1) Check if position is valid else return false
 *  2) Add current to the path
 *  3) Check if position is the target else return true.
 *  4) Recursively fo right until we return a false then go down
 *  5) in case we have nowhere to go remove current position from path list and return false
 */
public class Game {
    private static Position target;
    public static List<Position> findPath(Grid grid, int size) {
        target = new Position(0,size - 1);
        LinkedList<Position> path = new LinkedList<>();
        recursiveHelper(grid, new Position(size -1,0), path);
        Collections.reverse(path);
        return path;
    }

    private static boolean recursiveHelper(Grid grid, Position currentPosition, List<Position> pathSoFar){
        if(!grid.isValidPosition(currentPosition))
            return false;
        pathSoFar.add(currentPosition);
        if(target.equals(currentPosition)){
            return true;
        }

        if(recursiveHelper(grid, grid.goRight(currentPosition), pathSoFar)){
            return true;
        } else if (recursiveHelper(grid, grid.goDown(currentPosition), pathSoFar)){
            return true;
        }
        pathSoFar.remove(currentPosition);
        return false;
    }
}

