import java.util.Scanner;

/**
 * Main class for the Graphing Calculator program.
 * 
 * This program allows the user to:
 * - Choose and graph mathematical functions
 * - Adjust graph bounds and size
 * - Use a built-in basic calculator
 * 
 * The program uses menus, loops, conditionals, multiple classes,
 * and user input to demonstrate core CS1 concepts.
 * 
 * @author Dillon Miller
 */

public class Main {

    /** Scanner used for all user input */
    private static Scanner scanner = new Scanner(System.in);

    // Store graphing parameters here for persistence
    /** Currently selected function to graph */
    private static Function currentFunction = null;

    /** X-axis minimum bound */
    private static double minX = -10;
    /** X-axis maximum bound */
    private static double maxX = 10;
    /** Y-axis minimum bound */
    private static double minY = -10;
    /** Y-axis maximum bound */
    private static double maxY = 10;

    /** Width of the graph in characters */
    private static int width = 80;
    /** Height of the graph in characters */
    private static int height = 25;
    
    /** Calculator object used for arithmetic operations */
    private static BasicCalculator calc = new BasicCalculator();
    /** Grapher object used to plot functions */
    private static Grapher grapher = new Grapher();

    /**
     * Program entry point.
     * 
     * Test variables used to verify calculator functionality.
     * These are not part of the main program logic and are used
     * only to demonstrate testing during development.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
    	double testA = 10.0;
        double testB = 5.0;

     // Test addition
        double addTestResult = calc.add(testA, testB);
        System.out.println("TEST: add(" + testA + ", " + testB + ") = " + addTestResult);

        // Test multiplication
        double multiplyTestResult = calc.multiply(testA, testB);
        System.out.println("TEST: multiply(" + testA + ", " + testB + ") = " + multiplyTestResult);
        System.out.println();
        
    	showDefaultSettings();
        runMenuLoop();
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void showMenu() {
    	System.out.println();
        System.out.println("===================================");
        System.out.println("         GRAPHING CALCULATOR       ");
        System.out.println("===================================");
        System.out.println("1) Choose a function");
        System.out.println("2) Set X/Y bounds");
        System.out.println("3) Set graph width/height");
        System.out.println("4) Graph the function");
        System.out.println("5) Calculator");
        System.out.println("6) Quit");
        System.out.println("Enter Choice (1-6):");
    }

    /**
     * Runs the main menu loop.
     * 
     * This loop continues until the user chooses to quit.
     * Demonstrates both an infinite loop and a sentinel-controlled exit.
     */
    private static void runMenuLoop() {

        while (true) { 

            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Sentinel value to exit the loop
            if (choice == 6) {
                System.out.print("Are you sure you want to quit? (y/n): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("y")) {
                    System.out.println("Exiting program. Goodbye!");
                    break;
                }
            }

            // Menu option handling
            if (choice == 1) {
                chooseFunction();
            }
            else if (choice == 2) {
                setBounds();
            }
            else if (choice == 3) {
                setGraphSize();
            }
            else if (choice == 4) {
                graphFunction();
            }
            else if (choice == 5) {
                calculatorMenu();
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * Allows the user to choose which type of function to graph.
     */
    private static void chooseFunction() {
    	System.out.println();
        System.out.println("Choose a function:");
        System.out.println("1) Linear (y = mx + b)");
        System.out.println("2) Quadratic (y = ax^2 + bx + c)");
        System.out.println("3) Trigonometric Functions");
        System.out.println("4) Exponential (y = A * e^(B(x - C)) + D)");
        System.out.print("Enter choice (1-4): ");
        System.out.println();

        int choice = scanner.nextInt();
        scanner.nextLine();

        // Branch based on function choice
        if (choice == 1) {
            linearFunction();
        } 
        else if (choice == 2) {
            quadraticFunction();
        } 
        else if (choice == 3) {
            trigFunction();
        } 
        else if (choice == 4) {
            exponentialFunction();
        } 
        else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
    
    /**
     * Handles creation of trigonometric functions.
     */
    private static void trigFunction() {
        System.out.println("Choose a function:");
        System.out.println("1) Sine (y = A*sin(Bx + C) + D)");
        System.out.println("2) Cosine (y = A*cos(Bx + C) + D)");
        System.out.println("3) Tangent (y = A*tan(Bx + C) + D)");
        System.out.print("Enter choice (1-3): ");
        System.out.println();

        int trigChoice = scanner.nextInt();
        scanner.nextLine();

        // Collect parameters for trig functions
        System.out.print("Enter amplitude: ");
        double amplitude = scanner.nextDouble();

        System.out.print("Enter frequency B (period = 2π / |B|): ");
        double frequency = scanner.nextDouble();

        System.out.print("Enter phase shift: ");
        double phaseShift = scanner.nextDouble();

        System.out.print("Enter vertical shift: ");
        double verticalShift = scanner.nextDouble();
        scanner.nextLine();
   

        // Create selected trigonometric function
        if (trigChoice == 1) {
            currentFunction = new SineFunction(amplitude, frequency, phaseShift, verticalShift);
            System.out.println("Sine function set.");
        } 
        else if (trigChoice == 2) {
            currentFunction = new CosineFunction(amplitude, frequency, phaseShift, verticalShift);
            System.out.println("Cosine function set.");
        } 
        else if (trigChoice == 3) {
            currentFunction = new TangentFunction(amplitude, frequency, phaseShift, verticalShift);
            System.out.println("Tangent function set.");
        } 
        else {
            System.out.println("Invalid trig choice.");
        }
    }
    
    /**
     * Creates a linear function based on user input.
     */
    private static void linearFunction() {
    	System.out.println();
    	 
        System.out.print("Enter slope m: ");
        double slopeM = scanner.nextDouble();

        System.out.print("Enter y-intercept b: ");
        double yIntB = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        currentFunction = new LinearFunction(slopeM, yIntB);

        System.out.println("Linear function set: y = " + slopeM + "x + " + yIntB);
    }
    
    /**
     * Creates a quadratic function based on user input.
     */
    private static void quadraticFunction() {
    	System.out.println();
    	 
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        currentFunction = new QuadraticFunction(a, b, c);

        System.out.println("Quadratic function set: y = " + a + "x^2 + " + b + "x + " + c);
    }
    
    /**
     * Creates an exponential function based on user input.
     */
    private static void exponentialFunction() {
        System.out.println();

        System.out.print("Enter A (vertical stretch): ");
        double verticalStretchA = scanner.nextDouble();

        System.out.print("Enter B (exponent rate): ");
        double exponentB = scanner.nextDouble();

        System.out.print("Enter C (horizontal shift): ");
        double horizontalShiftC = scanner.nextDouble();

        System.out.print("Enter D (vertical shift): ");
        double verticalShiftD = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        currentFunction = new ExponentialFunction(verticalStretchA, exponentB, horizontalShiftC, verticalShiftD);

        System.out.println("Exponential function set: y = "
                + verticalStretchA
                + " * e^(" + exponentB + "(x - " + horizontalShiftC + ")) + "
                + verticalShiftD);
    }
    
    /**
     * Allows the user to set graph bounds.
     */
    private static void setBounds() {
        System.out.print("Enter min X: ");
        minX = scanner.nextDouble();
        System.out.print("Enter max X: ");
        maxX = scanner.nextDouble();
        System.out.print("Enter min Y: ");
        minY = scanner.nextDouble();
        System.out.print("Enter max Y: ");
        maxY = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        if (minX >= maxX || minY >= maxY) {
            System.out.println("Invalid bounds: min values must be less than max values.");
        } else {
            System.out.println("Bounds updated.");
        }
    }

    /**
     * Allows the user to change graph dimensions.
     */
    private static void setGraphSize() {
        System.out.print("Enter graph width (e.g. 80): ");
        width = scanner.nextInt();
        System.out.print("Enter graph height (e.g. 25): ");
        height = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (width <= 0 || height <= 0) {
            System.out.println("Invalid size: width and height must be positive.");
        } else {
            System.out.println("Graph size updated.");
        }
    }

    /**
     * Graphs the currently selected function.
     */
    private static void graphFunction() {
        if (currentFunction == null) {
            System.out.println("No function chosen yet. Please choose a function first.");
            return;
        }

        System.out.println("Graphing function...");
        grapher.plot(currentFunction, minX, maxX, minY, maxY, width, height);
    }
    
    /**
     * Displays default graph settings.
     */
    private static void showDefaultSettings() {
        System.out.println("Current graph settings:");
        System.out.println("Function: NONE");
        System.out.println("X bounds: minX = " + minX + ", maxX = " + maxX);
        System.out.println("Y bounds: minY = " + minY + ", maxY = " + maxY);
        System.out.println("Graph size: width = " + width + ", height = " + height);
    }
   
    /**
     * Runs the calculator submenu.
     */
    private static void calculatorMenu() {
        boolean running = true;

        while (running) {
            printCalculatorOptions();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 8) {
                running = false;
            } 
            else if (choice == 6) {
            	squareRoot(calc);
            } 
            else if (choice == 7) {
                castingDemo();
            }
            else {
                twoInputOperation(calc, choice);
            }
            System.out.println();
        }
    }
    
    /**
     * Displays calculator options.
     */
    private static void printCalculatorOptions() {
    	System.out.println();
        System.out.println("=========== BASIC CALCULATOR ===========");
        System.out.println("1) Add");
        System.out.println("2) Subtract");
        System.out.println("3) Multiply");
        System.out.println("4) Divide");
        System.out.println("5) Exponent (a^b)");
        System.out.println("6) Square Root");
        System.out.println("7) Casting Demo");
        System.out.println("8) Return to main menu");
        System.out.print("Choose an option: ");
    }
    
    /**
     * Handles calculator operations that require two inputs.
     */
    private static void twoInputOperation(BasicCalculator calc, int choice) {

        if (choice < 1 || choice > 5) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Enter first number: ");
        double firstTerm = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double secondTerm = scanner.nextDouble();
        scanner.nextLine();

        double result = 0;

        if (choice == 1)      result = calc.add(firstTerm, secondTerm);
        else if (choice == 2) result = calc.subtract(firstTerm, secondTerm);
        else if (choice == 3) result = calc.multiply(firstTerm, secondTerm);
        else if (choice == 4) result = calc.divide(firstTerm, secondTerm);
        else if (choice == 5) result = calc.exponent(firstTerm, secondTerm);

        System.out.println("Result = " + result);
        
        
    }
    
    /**
     * Handles square root calculations.
     */
    private static void squareRoot(BasicCalculator calc) {

        System.out.print("Enter number: ");
        double value = scanner.nextDouble();
        scanner.nextLine();

        double result = calc.sqrt(value);
        System.out.println("Result = " + result);
    }
    
    /**
     * Prompts the user for a decimal value and demonstrates
     * explicit type casting by converting it to an integer.
     */
    private static void castingDemo() {

        System.out.print("Enter a decimal number to cast to int: ");
        double value = scanner.nextDouble();
        scanner.nextLine();

        int castResult = calc.castDoubleToInt(value);

        System.out.println("Casted integer value: " + castResult);
    } 
}




