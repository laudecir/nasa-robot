package gov.nasa.robot.common;

import gov.nasa.robot.exception.OutsideAreaException;
import java.util.HashMap;
import java.util.Map;

public class Point {

    private int x;
    private int y;
    private Map<Character, Point> neighbours = new HashMap();

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCoordinate() {
        return x + ", " + y;
    }

    public Point ahead(char dir) throws OutsideAreaException {
        Point neighbor = neighbours.get(dir);
        if (neighbor == null) {
            throw new OutsideAreaException();
        }
        return neighbor;
    }

    public void addNeighbor(char orientation, Point neighbor) {
        neighbours.put(orientation, neighbor);
    }
}
