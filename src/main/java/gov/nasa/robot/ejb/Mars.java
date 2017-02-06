package gov.nasa.robot.ejb;

import gov.nasa.robot.common.Matrix;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class Mars {
    
    private static final int ROWS = 5;
    private static final int COLS = 5;

    private Matrix matrix;

    @PostConstruct
    public void postConstruct() {
        this.matrix = new Matrix(ROWS, COLS);
    }

    public Matrix getMatrix() {
        return this.matrix;
    }
    
}
