package Recursion;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import Recursion.RobotInAGrid.Grid;
import Recursion.RobotInAGrid.Position;
import Recursion.RobotInAGrid.Game;

import static org.junit.Assert.assertTrue;


/**
 * Created by Nicolas on 30/4/2018.
 */
public class RobotInAGridTest {

    @Test
    public void testFindPath() throws Exception {
        Grid grid = new Grid(5);
        grid.setPositionInValid(new Position(4,2));
        grid.setPositionInValid(new Position(2,3));
        grid.setPositionInValid(new Position(2,4));

        LinkedList<Position> correctPath = new LinkedList<>();
        correctPath.addFirst(new Position(4,0));
        correctPath.addFirst(new Position(4,1));
        correctPath.addFirst(new Position(3,1));
        correctPath.addFirst(new Position(3,2));
        correctPath.addFirst(new Position(2,2));
        correctPath.addFirst(new Position(1,2));
        correctPath.addFirst(new Position(1,3));
        correctPath.addFirst(new Position(1,4));
        correctPath.addFirst(new Position(0,4));

        List<Position> path = Game.findPath(grid, 5);

        assertTrue(correctPath.equals(path));
    }

}
