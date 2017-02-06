package gov.nasa.robot.exception;

public class OutsideAreaException extends Exception {

    public OutsideAreaException() {
        super("Outside the coverage area!");
    }

}