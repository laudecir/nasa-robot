package gov.nasa.robot.core;

import gov.nasa.robot.common.Direction;
import gov.nasa.robot.common.Point;
import gov.nasa.robot.exception.OutsideAreaException;

public abstract class RobotImpl implements Robot {

    private Point position;
    private Direction dir;

    @Override
    public void moveBySteps(String steps) throws OutsideAreaException {
        for (char step : steps.toCharArray()) {
            if (step == 'M') {
                Point p = position.ahead(dir.valueOf());
                setPosition(p);
            } else {
                Direction d = dir.rotate(step);
                setDir(d);
            }
        }
    }

    @Override
    public String getPosition() {
        StringBuilder pos = new StringBuilder();
        pos.append(position.getX()).append(", ")
                .append(position.getY()).append(", ")
                .append(dir.valueOf());
        return pos.toString();
    }

    public void setInitialPosition(Point point, Direction direction) {
        setPosition(point);
        setDir(direction);
    }

    private void setPosition(Point position) {
        this.position = position;
    }

    private void setDir(Direction dir) {
        this.dir = dir;
    }
}
