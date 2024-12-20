/*************************************************************************
 * Compilation: javac QuadraticKoch.java
 * Execution: java QuadraticKoch n
 *
 * @author Jeremy Hui
 *
 *************************************************************************/
public class QuadraticKoch {

    /**
     * Gets the set of coordinates to draw one segment of the Quadratic Koch Curve.
     * Returns the coordinates in a 2D array of doubles in the following format:
     * {array of x-coordinates,
     * array of y-coordinates}
     * 
     * @param x0 the x-coordinate of one endpoint
     * @param y0 the y-coordinate of one endpoint
     * @param x5 the x-coordinate of the other endpoint
     * @param y5 the y-coordinate of the other endpoint
     * @return the set of coordinates to draw one segment of the Quadratic Koch
     *         Curve
     */
    public static double[][] getCoords(double x0, double y0, double x5, double y5) {
        // WRITE YOUR CODE HERE
        double x = ((x5 - x0) / 3);
        double y = ((y5 - y0) / 3);
        double[][] coords = {
            {x0, (x0 + x), (x0 + x - y), (x5 - x - y), (x5 - x), x5},
            {y0, (y0 + y), (y0 + y + x), (y5 - y + x), (y5 - y), y5}
        };
        return coords;
    }


    /**
     * Gets the set of coordinates from getCoords() to draw the snowflake,
     * and calls Koch on two adjacent array indices with n being one less.
     * The method draws a line between the two endpoints if n == 0.
     * 
     * @param x0 the x-coordinate of one endpoint
     * @param y0 the y-coordinate of one endpoint
     * @param x5 the x-coordinate of the other endpoint
     * @param y5 the y-coordinate of the other endpoint
     * @param n  The current order
     */
    public static void koch(double x0, double y0, double x5, double y5, int n) {
        // WRITE YOUR CODE HERE
        if (n == 0) {
            StdDraw.line(x0, y0, x5, y5);
            return;
        }

        double coords[][] = getCoords(x0, y0, x5, y5);

        for (int i = 0; i < 5; i++) {
            koch(coords[0][i], coords[1][i], coords[0][i + 1], coords[1][i + 1], n - 1);
        }
    }



    /**
     * Takes an integer command-line argument n,
     * and draws a Quadratic Koch Curve of order n in a 1 x 1 canvas
     * with an initial square side length of 0.5.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // WRITE YOUR CODE HERE
        int ord = Integer.parseInt(args[0]);

        koch(0.25, 0.25, 0.25, 0.75, ord);
        koch(0.25, 0.75, 0.75, 0.75, ord);
        koch(0.75, 0.75, 0.75, 0.25, ord);
        koch(0.75, 0.25, 0.25, 0.25, ord);
    }
}