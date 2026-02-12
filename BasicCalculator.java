
/**
	 * A simple stateless calculator class that performs 
	 * basic arithmetic operations. 
	 * 
	 * This class demonstrates:
	 * - Algorithmic thinking
	 * - Methods with parameters & returns
	 * - Try/catch exception handling
	 * - Operator precedence
	 */
public class BasicCalculator {

	    /**
	     * Adds two numbers.
	     */
	    public double add(double a, double secondTerm) {
	        return a + secondTerm;
	    }

	    /**
	     * Subtracts b from a.
	     */
	    public double subtract(double a, double secondTerm) {
	        return a - secondTerm;
	    }

	    /**
	     * Multiplies two values.
	     */
	    public double multiply(double a, double secondTerm) {
	        return a * secondTerm;
	    }

	    /**
	     * Divides a by b. Uses try/catch to safely handle 
	     * division-by-zero errors.
	     */
	    public double divide(double a, double secondTerm) {
	        try {
	            return a / secondTerm;
	        } catch (ArithmeticException e) {
	            System.out.println("Error: Division by zero is not allowed.");
	            return Double.NaN; // return "Not a Number"
	        }
	    }

	    /**
	     * Computes a raised to the power of b.
	     */
	    public double exponent(double a, double secondTerm) {
	        return Math.pow(a, secondTerm);
	    }

	    /**
	     * Computes the square root of the given value.
	     * Uses try/catch in case the user passes a negative number.
	     */
	    public double sqrt(double value) {
	        try {
	            if (value < 0) {
	                throw new IllegalArgumentException("Cannot take sqrt of negative.");
	            }
	            return Math.sqrt(value);
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	            return Double.NaN;
	        }
	    }
	    
	    /**
	     * Demonstrates explicit type casting by converting
	     * a double value to an integer.
	     *
	     * This method is used for demonstration and testing purposes.
	     */
	    public int castDoubleToInt(double value) {
	        return (int) value; // explicit narrowing cast
	    }

}
