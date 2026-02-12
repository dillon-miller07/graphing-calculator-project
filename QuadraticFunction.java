
/**
 * Represents a quadratic mathematical function of the form:
 * 
 * y = ax² + bx + c
 * 
 * This class implements the Function interface and provides
 * an evaluation method for quadratic equations.
 */
public class QuadraticFunction implements Function {
	
    /** Coefficient a (controls the parabola's opening and width) */
	private double coefficentA;

    /** Coefficient b (controls the linear component) */
    private double coefficentB;

    /** Coefficient c (constant term / y-intercept) */
    private double coefficentC;
    
    /**
     * Constructs a quadratic function using the given coefficients.
     *
     * @param coefficentA the quadratic coefficient (a)
     * @param coefficentB the linear coefficient (b)
     * @param coefficentC the constant term (c)
     */
    public QuadraticFunction(double coefficentA, double coefficentB, double coefficentC) {
        this.coefficentA = coefficentA;
        this.coefficentB = coefficentB;
        this.coefficentC = coefficentC;
    }

    /**
     * Evaluates the quadratic function at a given x-value.
     *
     * @param x the input value
     * @return the computed y-value using y = ax² + bx + c
     */
    @Override
    public double evaluate(double x) {
        // Apply the quadratic formula
    	double y = coefficentA * Math.pow(x, 2) + coefficentB * x + coefficentC;
        return y;
    }
}