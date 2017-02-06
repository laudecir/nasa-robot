package gov.nasa.robot.common;

import static gov.nasa.robot.common.Constants.*;

public class Matrix {

    private int rows;
    private int cols;
    private Point[][] points;

    public Matrix() {
        // default length
        this(5, 5);
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        init();
    }

    private void init() {
        points = new Point[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                points[x][y] = new Point(x, y);
            }
        }

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                Point point = points[x][y];
                joinNeighbours(point);
            }
        }
    }

    private void joinNeighbours(Point point) {
        int x = point.getX();
        int y = point.getY();

        int n = y + 1;
        int e = x + 1;
        int s = y - 1;
        int w = x - 1;

        if (n <= (rows - 1)) {
            point.addNeighbor(N, points[x][n]);
        }
        if (e <= (cols - 1)) {
            point.addNeighbor(E, points[e][y]);
        }
        if (s >= 0) {
            point.addNeighbor(S, points[x][s]);
        }
        if (w >= 0) {
            point.addNeighbor(W, points[w][y]);
        }
    }

    public Point getPoint(int x, int y) {
        return points[x][y];
    }
}
