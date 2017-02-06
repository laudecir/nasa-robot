package gov.nasa.robot.core;

import gov.nasa.robot.exception.OutsideAreaException;

public interface Robot {

    void moveBySteps(String steps) throws OutsideAreaException;

    String getPosition();

}
