package Arrays;

import Arrays.TickTack.Cell;
import Arrays.TickTack.TicTacToeGame;
import Arrays.TickTack.Point;
import Arrays.TickTack.TickTackToeValue;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Nicolas on 20/5/2018.
 */
public class TicTackToeTest {

    @Test
    public void testHasWon() throws Exception {
        Cell[][] grid = new Cell[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new Cell(i,j, TickTackToeValue.EMPTY);
            }
        }

        grid[1][1].value = TickTackToeValue.X;
        grid[2][2].value = TickTackToeValue.X;
        grid[3][3].value = TickTackToeValue.X;
        grid[0][0].value = TickTackToeValue.O;

        assertTrue(TicTacToeGame.hasWon(grid, new Point(3,3)));
        assertTrue(TicTacToeGame.hasWon(grid, new Point(2,2)));
        assertTrue(TicTacToeGame.hasWon(grid, new Point(1,1)));
        assertFalse(TicTacToeGame.hasWon(grid, new Point(0,0)));
    }

}
