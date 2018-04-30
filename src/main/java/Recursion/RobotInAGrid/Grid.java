package Recursion.RobotInAGrid;

import java.util.Arrays;

/**
 * Created by Nicolas on 24/12/2017.
 */
public class Grid {
    private Boolean[][] grid;

    public Grid(int size) {
        this.grid = new Boolean[size][size];
        for (int i = 0; i < grid.length; i++) {
           Arrays.fill(this.grid[i], true);
        }
    }

    public void setPositionValid(Position position){
        //should check the validity of the coordinates
        grid[position.getRow()][position.getColumn()] = true;
    }

    public void setPositionInValid(Position position){
        //should check the validity of the coordinates
        grid[position.getRow()][position.getColumn()] = false;
    }

    public Position goDown(Position position){
        return new Position(position.getRow() - 1, position.getColumn());
    }

    public Position goRight(Position position){
        return new Position(position.getRow() , position.getColumn()+ 1);
    }

    public boolean isValidPosition(Position position){
        if(position.getColumn() >= grid.length){
            return false;
        }

        if(position.getRow() >= grid.length){
            return false;
        }
        if(position.getColumn() <0 || position.getRow()<0)
            return false;

        if(!grid[position.getRow()][position.getColumn()])
            return false;

        return true;
    }

}
