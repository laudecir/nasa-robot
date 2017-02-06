package gov.nasa.robot.ejb;

import gov.nasa.robot.common.Direction;
import gov.nasa.robot.common.Point;
import gov.nasa.robot.core.RobotImpl;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RobotMars extends RobotImpl {

    @Inject
    private Mars mars;

    @PostConstruct
    public void postConstruct() {
        Point initPoint = mars.getMatrix().getPoint(0, 0);
        Direction initDir = Direction.NORTH;
        setInitialPosition(initPoint, initDir);
    }
}
