package gov.nasa.robot.test;

import gov.nasa.robot.ejb.RobotMars;
import gov.nasa.robot.exception.OutsideAreaException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class DeploymentTest {

    private static final String ROOT_PACKAGE = "gov.nasa.robot";

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class, "restest.war");
        war.addPackages(true, Filters.exclude(DeploymentTest.class.getPackage()), ROOT_PACKAGE);
        return war;
    }

    @Inject
    private RobotMars robot;

    @Test
    public void testMoveRobot() throws OutsideAreaException {
        {
            String steps = "MMRMMRMM";
            String finalPosition = "2, 0, S";
            moveBySteps(steps, finalPosition);
        }
        {
            String steps = "MML";
            String finalPosition = "0, 2, W";
            moveBySteps(steps, finalPosition);
        }
        {
            String steps = "MMMMR";
            String finalPosition = "0, 4, E";
            moveBySteps(steps, finalPosition);
        }
        {
            String steps = "RMMMMLL";
            String finalPosition = "4, 0, W";
            moveBySteps(steps, finalPosition);
        }
        {
            String steps = "RMLMRMLMRMLMRMLM";
            String finalPosition = "4, 4, N";
            moveBySteps(steps, finalPosition);
        }

    }

    private void moveBySteps(String steps, String finalPosition) throws OutsideAreaException {
        robot.moveBySteps(steps);
        System.out.println(robot.getPosition());
        assertEquals("Coordinate incorrect!", robot.getPosition(), finalPosition);
        logCoordinate(steps, robot.getPosition());
        robot.postConstruct();
    }

    private void logCoordinate(String steps, String position) {
        String message = "Step: " + steps + "\tPosition: " + position;
        Logger.getLogger(DeploymentTest.class.getName()).log(Level.INFO, message);
    }
}
