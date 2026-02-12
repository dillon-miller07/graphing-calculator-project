
public interface Function {

    // Abstract method (every function class MUST implement this)
    
    /**
     * Evaluates the function at the given x-value.
     * @param x the input value
     * @return the output of the function at x
     */
    double evaluate(double x);
}