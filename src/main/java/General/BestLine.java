package General;

import General.helper.Line;
import General.helper.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Question:
 * Given a 2 dimensional graph with points on it, find a line which passes the most number of points.
 *
 * Mistakes:
 * - A line can be represented by y = (y1-y2)/(x1-x2) and y intercept (the point that the line intercept the y-axis
 * - Yintercept = y - slope*x (for any y & x of the 2 available points)
 * - slope = (y1 - y2)/(x1-x2)
 * - If a line is horizontal yintercept is inf so mark it with a boolean
 * - To avoid double counting a line for points A,B as line (A->B) & (B->A) use the j = i + 1 in the second loop
 * for (int i = 0; i < points.size(); i++) {
 * for (int j = i+1; j < points.size(); j++) {....
 *
 * Solution:
 * 1) Create a Map of slope(key) -> lines(value), each line is represented as slope & y-intercept values.
 * 1.1) We use only 3 digit precision for slope.
 * 2) Iterate each slope and count the max lines with the same yIntercept.
 *
 */
public class BestLine {
    public static Line getBestLine(List<Point> points) {
        HashMap<Double, List<Line>> linesBySlope = getLines(points);
        return bestLine(linesBySlope);
    }

    private static HashMap<Double, List<Line>> getLines(List<Point> points) {
        HashMap<Double, List<Line>> linesBySlope = new HashMap<>();

        for (int i = 0; i < points.size(); i++) {
            Point start = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point end = points.get(j);
                Line line = new Line(start, end);
                double slope = line.slope;

                List<Line> lines = linesBySlope.get(slope);
                if (lines == null) {
                    lines = new ArrayList<>();
                }
                lines.add(line);
                linesBySlope.put(slope, lines);
            }
        }
        return linesBySlope;
    }

    private static Line bestLine(HashMap<Double, List<Line>> linesBySlope) {
        int maxLines = 0;
        Line bestLine = null;

        for (Double slope : linesBySlope.keySet()) {
            List<Line> sameSlopeLines = linesBySlope.get(slope);
            for (Line line : sameSlopeLines) {

                int countLines = countEqualLines(line, sameSlopeLines);
                if (countLines > maxLines) {
                    bestLine = line;
                    maxLines = countLines;
                }
            }
        }
        return bestLine;
    }

    private static int countEqualLines(Line line, List<Line> lines) {
        int count = 0;
        for (Line tmpLine : lines) {
            if (line.isHorizontal == tmpLine.isHorizontal && line.yIntercept == tmpLine.yIntercept) {
                count++;
            }
        }
        return count;
    }
}
