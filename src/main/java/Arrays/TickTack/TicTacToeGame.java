package Arrays.TickTack;

/**
 * Question:
 *  Design an algorithm to figure out if someone has won a game of tic-tac-toe
 *
 * Mistakes:
 *  - Check every position before accessing it
 *
 * Solution:
 *  Given the last played position we check the 5 possible 3x3 subgrids that can include the played position.
 *      1) the played position is the bottom left
 *      2) the played position is the bottom right
 *      3) the played position is the center
 *      4) the played position is the upper left
 *      5) the played position is the upper right
 */
public class TicTacToeGame {
    public static boolean hasWon(Cell[][] grid, Point lastPositionPlayed) {
        //Check up right
        Point up = new Point(lastPositionPlayed.getRow()- 2, lastPositionPlayed.getColumn());
        if(check3x3subgrid(grid,up, lastPositionPlayed )){
            return true;
        }

        //Check up left
        Point upLeft = new Point(lastPositionPlayed.getRow()- 2, lastPositionPlayed.getColumn() - 2);
        if(check3x3subgrid(grid, upLeft, lastPositionPlayed )){
            return true;
        }

        //Check lower right
        if(check3x3subgrid(grid, lastPositionPlayed, lastPositionPlayed )){
            return true;
        }

        //Check lower left
        Point lowerLeft = new Point(lastPositionPlayed.getRow(), lastPositionPlayed.getColumn() - 2);
        if(check3x3subgrid(grid, lowerLeft, lastPositionPlayed )){
            return true;
        }

        //Check center
        Point centerLeft = new Point(lastPositionPlayed.getRow() - 1, lastPositionPlayed.getColumn() - 1);
        if(check3x3subgrid(grid, centerLeft, lastPositionPlayed )){
            return true;
        }

        return false;

    }

    private static boolean check3x3subgrid(Cell[][] grid, Point upperLeft, Point lastPlayerPosition) {
        //check if upperLeftPoint is withing the grid
        if (!inBound(upperLeft, grid)) {
            return false;
        }
        TickTackToeValue playerValue = grid[lastPlayerPosition.getRow()][lastPlayerPosition.getColumn()].value;

        if (checkRow(grid, upperLeft, playerValue, lastPlayerPosition.getRow()))
            return true;

        if (checkColumn(grid, upperLeft, playerValue, lastPlayerPosition.getColumn()))
            return true;

        if (checkDiagonal(grid, upperLeft, playerValue))
            return true;

        if (checkAntidiagonal(grid, upperLeft, playerValue))
            return true;
        return false;
    }

    private static boolean inBound(Point upperRightPoint, Cell[][] grid) {
        if (upperRightPoint.getColumn() < 0 || upperRightPoint.getRow() < 0)
            return false;

        if (upperRightPoint.getRow() >= grid.length)
            return false;

        if (upperRightPoint.getColumn() >= grid[0].length)
            return false;

        return true;
    }

    private static boolean checkRow(Cell[][] grid, Point upperLeftPoint, TickTackToeValue playerValue, int row) {
        for (int tmpColumn = upperLeftPoint.getColumn(); tmpColumn <= upperLeftPoint.getColumn() + 2; tmpColumn++) {
            Point tmpPoint = new Point(row, tmpColumn);
            if (inBound(tmpPoint, grid) && grid[row][tmpColumn].value != playerValue)
                return false;
        }

        return true;
    }

    private static boolean checkColumn(Cell[][] grid, Point upperLeftPoint, TickTackToeValue playerValue, int column) {
        for (int tmpRow = upperLeftPoint.getRow(); tmpRow <= upperLeftPoint.getRow() + 2; tmpRow++) {
            Point tmpPoint = new Point(tmpRow, column);
            if (inBound(tmpPoint, grid) && grid[tmpRow][column].value != playerValue)
                return false;
        }
        return false;
    }

    private static boolean checkDiagonal(Cell[][] grid, Point upperLeftPoint, TickTackToeValue playerValue) {
        for (int i = 0; i < 3; i++) {
            Point tmpPoint = new Point(upperLeftPoint.getRow() + i, upperLeftPoint.getColumn() + i);
            if(inBound(tmpPoint, grid) && grid[upperLeftPoint.getRow() + i][upperLeftPoint.getColumn() + i].value != playerValue)
                return false;
        }
        return true;
    }

    private static boolean checkAntidiagonal(Cell[][] grid, Point upperLeftPoint, TickTackToeValue playerValue) {
        Point tmpPoint = new Point(upperLeftPoint.getRow() + 1, upperLeftPoint.getColumn() + 1);
        if (inBound(tmpPoint, grid) && grid[upperLeftPoint.getRow() + 1][upperLeftPoint.getColumn() + 1].value != playerValue)
            return false;
        tmpPoint = new Point(upperLeftPoint.getRow(), upperLeftPoint.getColumn() + 2);
        if (inBound(tmpPoint, grid) && grid[upperLeftPoint.getRow()][upperLeftPoint.getColumn() + 2].value != playerValue)
            return false;
        tmpPoint = new Point(upperLeftPoint.getRow() + 2, upperLeftPoint.getColumn());
        if (inBound(tmpPoint, grid) && grid[upperLeftPoint.getRow()+ 2][upperLeftPoint.getColumn() ].value != playerValue)
            return false;

        return true;
    }
}
