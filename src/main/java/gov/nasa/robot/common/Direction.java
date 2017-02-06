package gov.nasa.robot.common;

import gov.nasa.robot.exception.OutsideAreaException;
import static gov.nasa.robot.common.Constants.*;
import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(N, LRDir(W, E)),
    SOUTH(S, LRDir(E, W)),
    EAST(E, LRDir(N, S)),
    WEST(W, LRDir(S, N));

    private final char value;
    private Map<Character, Character> sides;

    private Direction(char value, Map<Character, Character> sides) {
        this.value = value;
        this.sides = sides;
    }

    private static Map LRDir(char LDir, char RDir) {
        Map map = new HashMap();
        map.put('L', LDir);
        map.put('R', RDir);
        return map;
    }

    public char valueOf() {
        return this.value;
    }

    private Direction valueOf(char dir) {
        for (Direction direction : Direction.values()) {
            if (dir == direction.valueOf()) {
                return direction;
            }
        }
        return null;
    }

    public Direction rotate(char side) throws OutsideAreaException {
        Character dir = this.sides.get(side);
        if (dir == null) {
            throw new OutsideAreaException();
        }
        Direction direction = valueOf(dir);
        return direction;
    }
}
