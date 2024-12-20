import java.awt.Color;




/*************************************************************************
*  Compilation:  javac Matryoshka.java
*  Execution:    java Matryoshka n
*
*  @author Pooja Kedia
*
*************************************************************************/
public class Matryoshka {




  /**
   * Helper method to draw face on the 'head' structure of the doll
   *
   * @param  head_x the x-coordinate of the center of doll's head
   * @param  head_y the y-coordinate of the center of doll's head
   * @param  radius the radius of the doll's body
   */
  public static void drawFace(double head_x, double head_y, double radius) {
      StdDraw.setPenColor(Color.black);
      StdDraw.filledCircle(head_x + ((1.0 / 5.0) * radius), head_y + ((1.0 / 6.0) * radius), radius * (1.0 / 10.0));  // Left eye
      StdDraw.filledCircle(head_x - ((1.0 / 5.0) * radius), head_y + ((1.0 / 6.0) * radius), radius * (1.0 / 10.0));  // Right eye
      StdDraw.line(head_x - ((1.0 / 8.0) * radius), head_y - ((1.0 / 6.0) * radius), head_x + ((1.0 / 8.0) * radius), head_y - ((1.0 / 6.0) * radius));  // Mouth line
      StdDraw.arc(head_x, head_y - ((1.0 / 6.0) * radius), ((1.0 / 8.0) * radius), 180, 360);  // Smile arc
  }




  /**
   * Draws a circle as the doll body using the specified x, y, and radius values,
   * Draws another circle of 1/2 times the size placed on top of the body as the 'head',
   * Calls the helper method drawFace with the x, y coordinates that are the center of the 'head' circle and body radius.
   *
   * @param  x the x-coordinate of the center of doll's body
   * @param  y the y-coordinate of the center of doll's body
   * @param  radius the radius of the doll's body
   */
  public static void drawDoll(double x, double y, double radius) {
      // Draw the body of the doll (circle)
      StdDraw.circle(x, y, radius);




      // Draw the head of the doll (circle), with half the radius of the body
      // Move the head further up by increasing the offset
      StdDraw.circle(x, y + radius + (radius / 2), radius / 2);  // Increase the offset for the head




      // Draw the face on the head
      drawFace(x, y + radius + (radius / 2), radius);  // Adjust face position as well
  }




  /**
   * Draws a doll at initially specified position,
   * draws another doll of 5/7 times the size adjacent to the previous doll,
   * terminates when there are no dolls remaining to draw.
   *
   * @param  x the x-coordinate of the center of the doll's body
   * @param  y the y-coordinate of the center of the doll's body
   * @param  r the radius of the doll's body
   * @param dolls the number of dolls to be drawn in succession
   */
  public static void stackDolls(double x, double y, double r, int dolls) {
      // Base case: if no dolls are left to draw, stop recursion
      if (dolls == 0) {
          return;
      }




      // Draw the current doll
      drawDoll(x, y, r);




      // Recursive call to draw the next doll, smaller and adjacent
      stackDolls(x + r +r * 5 / 7, y, r * 5 / 7, dolls - 1);
  }




  /**
   * Takes in an integer command-line argument dolls,
   * which represents the number of dolls to draw,
   * and draws a succession of Matryoshka dolls on a 1 x 1 canvas
   * @param args command-line arguments
   */
  public static void main(String[] args) {
      // Read the number of dolls to be drawn from the command-line argument
      int numberOfDolls = Integer.parseInt(args[0]);




      // Set the canvas size
      StdDraw.setCanvasSize(500, 500);




      // Start drawing dolls from position (0.1, 0.1) with initial radius 0.1
      stackDolls(0.1, 0.1, 0.1, numberOfDolls);




      // Show the canvas after drawing is done
      StdDraw.show();
  }
}









