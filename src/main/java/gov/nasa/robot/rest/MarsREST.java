package gov.nasa.robot.rest;

import gov.nasa.robot.exception.OutsideAreaException;
import gov.nasa.robot.ejb.RobotMars;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/mars")
public class MarsREST {

    @Inject
    private RobotMars robot;

    @POST
    @Path("/{steps}")
    public String controlRobot(@PathParam("steps") String steps) {
        try {
            robot.moveBySteps(steps);
            return robot.getPosition();
        } catch (OutsideAreaException ex) {
            Logger.getLogger(MarsREST.class.getName()).log(Level.SEVERE, "BAD REQUEST", ex);
            return "400 Bad Request";
        }
    }
}
