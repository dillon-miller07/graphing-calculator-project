
/**
 * Represents a tangent trigonometric function of the form:
 * 
 * y = A * tan(Bx + C) + D
 * 
 * This class implements the Function interface and allows
 * evaluation of tangent functions with configurable parameters.
 */
public class TangentFunction implements Function {

    /** Amplitude (A): controls the vertical stretch of the graph */
    private double amplitude;

    /** Frequency (B): affects the period of the tangent function */
    private double frequency;

    /** Phase shift (C): shifts the graph horizontally */
    private double phaseShift;

    /** Vertical shift (D): moves the graph up or down */
    private double verticalShift;

    /**
     * Constructs a tangent function with the specified parameters.
     *
     * @param amplitude the amplitude of the tangent function
     * @param frequency the frequency factor
     * @param phaseShift the horizontal phase shift
     * @param verticalShift the vertical shift
     */
    public TangentFunction(double amplitude, double frequency, double phaseShift, double verticalShift) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.phaseShift = phaseShift;
        this.verticalShift = verticalShift;
    }

    /**
     * Evaluates the tangent function at a given x-value.
     *
     * @param x the input value
     * @return the computed y-value
     */
    @Override
    public double evaluate(double x) {
        // Apply the tangent function formula
        return amplitude * Math.tan(frequency * x + phaseShift) + verticalShift;
    }
}