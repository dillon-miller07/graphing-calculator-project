
/**
 * Represents a sine trigonometric function of the form:
 * 
 * y = A * sin(Bx + C) + D
 * 
 * This class implements the Function interface and allows
 * evaluation of sine functions with configurable parameters.
 */
public class SineFunction implements Function {

    /** Amplitude (A): controls the height of the wave */
    private double amplitude;

    /** Frequency (B): controls the period of the wave */
    private double frequency;

    /** Phase shift (C): shifts the wave horizontally */
    private double phaseShift;

    /** Vertical shift (D): shifts the wave up or down */
    private double verticalShift;

    /**
     * Constructs a sine function with the given parameters.
     *
     * @param amplitude the amplitude of the sine wave
     * @param frequency the frequency factor
     * @param phaseShift the horizontal shift
     * @param verticalShift the vertical shift
     */
    public SineFunction(double amplitude, double frequency, double phaseShift, double verticalShift) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.phaseShift = phaseShift;
        this.verticalShift = verticalShift;
    }

    /**
     * Evaluates the sine function at a given x-value.
     *
     * @param x the input value
     * @return the calculated y-value
     */
    @Override
    public double evaluate(double x) {
        // Apply the sine function formula
        return amplitude * Math.sin(frequency * x + phaseShift) + verticalShift;
    }
}