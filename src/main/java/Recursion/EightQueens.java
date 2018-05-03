package Recursion;


import java.util.ArrayList;

/**
 * Question:
 *  Write an algorithm to print all ways of arranging 8 queens on an 8x8 chess board so that none of them share the same
 *  row, column or diagonal.
 *
 * Mistakes:
 *
 *
 * Solution:
 *      Create an array of 8 cells, each cell represents a row in the board, the value inside is the column we place the queen
 *      for this row. eg: grid[5] = 6 says that in row 5 the column 6 is placed with a queen.
 *
 *      1) Recurse for each row and for this row check all possible columns we can insert a queen.
 *          1.1) If row >= 8 stop the iteration.
 *          1.2) for each column before inserting it check if it is valid, if it is add it to the array (grid) and
 *               recurse to next row.
 *      2) How to check if a cell is a valid position?
 *          2.1) Iterate all the grid row by row, start from row 0 till the current row (the position we want to insert a queen),
 *          2.2) For each iteration check if current column == tmp column (column that may already have a queen from in a previous row.
 *          2.3) If the above is false check the diagonals: diffColumns must not be equals to diffRows.
 *
 */
public class EightQueens {
    private static final int GRID_SIZE = 8;
    public static void placeQueens(int currentRow, Integer[] grid, ArrayList<Integer[]> results) {
        if(currentRow == GRID_SIZE) {
            results.add(grid);
            return;
        } else {
            for (int currentColumn = 0; currentColumn < GRID_SIZE; currentColumn++) {
                if(isValid(grid, currentRow, currentColumn)){
                    grid[currentRow] = currentColumn;
                    placeQueens(currentRow+1, grid, results);
                }
            }
        }
    }

    private static boolean isValid(Integer[] grid, int row, int column){
        for (int tmpRow = 0; tmpRow < row; tmpRow++) {
            int tmpColumn = grid[tmpRow];
            if(tmpColumn == column)
                return false;
            int columnDiff = Math.abs(tmpColumn - column);
            int rowDiff = tmpRow - row;
            if(rowDiff == columnDiff)
                return false;
        }
        return true;
    }
}
