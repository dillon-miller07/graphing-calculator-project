/**
 * Represents a linear mathematical function of the form:
 * 
 * y = mx + b
 * 
 * where:
 * m = slope
 * b = y-intercept
 * 
 * This class implements the Function interface and
 * provides an evaluation of a linear function.
 */
public class LinearFunction implements Function {
	
    /** Slope of the line (m) */
	private double slopeM;

    /** Y-intercept of the line (b) */
    private double yIntB;
    
    /**
     * Constructs a linear function with the given slope and y-intercept.
     *
     * @param slopeM the slope of the line
     * @param yIntB the y-intercept
     */
    public LinearFunction(double slopeM, double yIntB) {
        this.slopeM = slopeM;
        this.yIntB = yIntB;
    }

    /**
     * Evaluates the linear function at the given x-value.
     *
     * @param x the input value
     * @return the computed y-value using y = mx + b
     */
    @Override
    public double evaluate(double x) {
        // Apply the linear function formula
    	double y = slopeM * x + yIntB;
        return y;
    }
}
	
	
	
	
	
	
	
	
	
