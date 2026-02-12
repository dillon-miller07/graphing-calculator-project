
/**
 * Represents a cosine mathematical function of the form:
 * 
 * y = A * cos(Bx + C) + D
 * 
 * where:
 * A = amplitude
 * B = frequency
 * C = phase shift
 * D = vertical shift
 * 
 * This class implements the Function interface and provides
 * an implementation of the evaluate method.
 */
public class CosineFunction implements Function {

    /** Amplitude of the cosine function */
    private double amplitude;

    /** Frequency (controls the period) of the cosine function */
    private double frequency;

    /** Phase shift of the cosine function */
    private double phaseShift;

    /** Vertical shift of the cosine function */
    private double verticalShift;

    /**
     * Constructs a cosine function with the given parameters.
     *
     * @param amplitude the amplitude (A)
     * @param frequency the frequency (B)
     * @param phaseShift the phase shift (C)
     * @param verticalShift the vertical shift (D)
     */
    public CosineFunction(double amplitude, double frequency, double phaseShift, double verticalShift) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.phaseShift = phaseShift;
        this.verticalShift = verticalShift;
    }

    /**
     * Evaluates the cosine function at the given x-value.
     *
     * @param x the input value
     * @return the computed y-value of the cosine function
     */
    @Override
    public double evaluate(double x) {
        // Apply the cosine formula using Math.cos
        return amplitude * Math.cos(frequency * x + phaseShift) + verticalShift;
    }
}