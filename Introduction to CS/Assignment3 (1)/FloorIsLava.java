
/*************************************************************************
 *  Compilation:  javac FloorIsLava.java
 *  Execution:    java FloorIsLava n
 *
 *  @author Shane Haughton, Maaz Mansuri
 *
 **************************************************************************/

 public class FloorIsLava {
    public static void main(String[] args) {
        // Parse input argument as an integer
        int n = Integer.parseInt(args[0]);
        
        // If n is 0, print nothing
        if (n == 0) {
            return;
        }

        // First, print even numbers in asc order
        for (int i = 2; i <= n; i += 2) {
            System.out.print(i + " ");
        }

        // Then, print odd numbers in desc order
        for (int i = n; i >= 1; i--) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }
}