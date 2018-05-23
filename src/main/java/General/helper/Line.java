package General.helper;

import java.math.BigDecimal;

/**
 * Created by Nicolas on 17/1/2018.
 */
public class Line {
    public double yIntercept;
    public double slope;
    public boolean isHorizontal = false;

    public Line(Point start, Point end) {
        if (Math.abs(start.x - end.x) > 0.0001) {
            slope = (start.y - end.y) / (start.x - end.x);
            //Round to 3 digits.
            slope = BigDecimal.valueOf(slope).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
            //from y = mx+b the point where the line meets the y-axis
            yIntercept = start.y - slope * start.x;
        } else {
            isHorizontal = true;
            yIntercept = start.x;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (Double.compare(line.yIntercept, yIntercept) != 0) return false;
        if (Double.compare(line.slope, slope) != 0) return false;
        return isHorizontal == line.isHorizontal;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(yIntercept);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(slope);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isHorizontal ? 1 : 0);
        return result;
    }
}
