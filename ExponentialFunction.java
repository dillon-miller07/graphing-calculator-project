
/**
 * Represents an exponential mathematical function of the form:
 * 
 * y = A * e^(B(x - C)) + D
 * 
 * where:
 * A = vertical stretch
 * B = exponent rate
 * C = horizontal shift
 * D = vertical shift
 * 
 * This class implements the Function interface and provides
 * an evaluation of the exponential function.
 */
public class ExponentialFunction implements Function {

    /** Vertical stretch factor (A) */
	private double verticalStretchA;

    /** Exponent growth/decay rate (B) */
	private double exponentB;

    /** Horizontal shift (C) */
	private double horizontalShiftC;

    /** Vertical shift (D) */
	private double verticalShiftD;

    /**
     * Constructs an exponential function with the given parameters.
     *
     * @param verticalStretchA the vertical stretch (A)
     * @param exponentB the exponent rate (B)
     * @param horizontalShiftC the horizontal shift (C)
     * @param verticalShiftD the vertical shift (D)
     */
    public ExponentialFunction(double verticalStretchA, double exponentB,
                               double horizontalShiftC, double verticalShiftD) {
        this.verticalStretchA = verticalStretchA;
        this.exponentB = exponentB;
        this.horizontalShiftC = horizontalShiftC;
        this.verticalShiftD = verticalShiftD;
    }

    /**
     * Evaluates the exponential function at the given x-value.
     *
     * @param x the input value
     * @return the computed y-value of the exponential function
     */
    @Override
    public double evaluate(double x) {
        // Apply the exponential function formula using Math.exp
    	double y = verticalStretchA * Math.exp(exponentB * (x - horizontalShiftC)) + verticalShiftD;
    	return y;
    }
}