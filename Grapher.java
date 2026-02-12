/**
 * Grapher class for plotting mathematical functions as ASCII art on a console grid.
 * 
 * This class allows you to define a coordinate system with minimum and maximum
 * X and Y values, specify the size of the plotting grid, and then plot a function
 * using ASCII characters.
 * 
 * @author Dillon Miller
 */

public class Grapher {

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private int width;
    private int height;

    /**
     * Sets the plotting boundaries and grid size, then calls the plot method
     * that actually draws the function on the ASCII grid.
     * 
     * @param f The function to plot
     * @param minX Minimum x-value
     * @param maxX Maximum x-value
     * @param minY Minimum y-value
     * @param maxY Maximum y-value
     * @param width Width of the ASCII grid
     * @param height Height of the ASCII grid
     */
    public void plot(Function f, double minX, double maxX, double minY, double maxY, int width, int height) {
        // Store the plotting boundaries and grid size in fields
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.width = width;
        this.height = height;

        plot(f);  // Call the main plotting function
    }

    /**
     * Plots the function on the ASCII grid using stored boundaries and grid size.
     * 
     * @param f The function to plot
     */
    public void plot(Function f) {
        // Create a blank grid filled with spaces
        char[][] grid = new char[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = ' '; // fill grid with blank spaces
            }
        }

        drawAxes(grid); // Draw X and Y axes on the grid

        // Plot each point of the function
        for (double x = minX; x <= maxX; x += 0.1) {
            double y = f.evaluate(x); // Get y-value from function

            int col = xToCol(x); // Convert x to column index
            int row = yToRow(y); // Convert y to row index

            // Check bounds and place '*' character on the grid
            if (col >= 0 && col < width && row >= 0 && row < height) {
                grid[row][col] = '*';
            }
        }

        printGrid(grid); // Print the final ASCII grid
    }

    /**
     * Converts an x-value to the corresponding column index in the ASCII grid.
     * 
     * @param x The x-value
     * @return Column index on the grid
     */
    private int xToCol(double x) {
        double percent = (x - minX) / (maxX - minX);
        return (int)(percent * (width - 1)); // Scale to grid width
    }

    /**
     * Converts a y-value to the corresponding row index in the ASCII grid.
     * 
     * @param y The y-value
     * @return Row index on the grid
     */
    private int yToRow(double y) {
        double percent = (y - minY) / (maxY - minY);

        // Flip vertically because row 0 is at the top
        return height - 1 - (int)(percent * (height - 1));
    }

    /**
     * Draws the coordinate axes on the ASCII grid.
     * 
     * @param grid The ASCII grid
     */
    private void drawAxes(char[][] grid) {
        int xAxisRow = yToRow(0); // Row for x-axis
        int yAxisCol = xToCol(0); // Column for y-axis

        // Draw horizontal x-axis
        if (xAxisRow >= 0 && xAxisRow < height) {
            for (int col = 0; col < width; col++) {
                grid[xAxisRow][col] = '-';
            }
        }

        // Draw vertical y-axis
        if (yAxisCol >= 0 && yAxisCol < width) {
            for (int row = 0; row < height; row++) {
                grid[row][yAxisCol] = '|';
            }
        }

        // Mark the origin
        if (xAxisRow >= 0 && xAxisRow < height && yAxisCol >= 0 && yAxisCol < width) {
            grid[xAxisRow][yAxisCol] = '+';
        }
    }

    /**
     * Prints the ASCII grid row by row to the console.
     * 
     * @param grid The ASCII grid
     */
    private void printGrid(char[][] grid) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print(grid[row][col]);
            }
            System.out.println(); // Move to next line after each row
        }
    }    
}