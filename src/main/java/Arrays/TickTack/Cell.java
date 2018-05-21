package Arrays.TickTack;

/**
 * Created by Nicolas on 14/1/2018.
 */
public class Cell {

    public Point point;
    public TickTackToeValue value;

    public Cell(int row, int column, TickTackToeValue value) {
        point = new Point(row, column);
        this.value = value;
    }
}
