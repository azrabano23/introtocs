/*
 * Write your program inside the main method to find the order
 * which the bus the student needs to take will arrive
 * according to the assignemnt description. 
 *
 * To compile:
 *        javac BusStop.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class BusStop {
    public static void main(String[] args) {
        int n = args.length; // Total number of characters passed
        if (n < 2) {
            System.out.println("-1");
            return;
        }

        // Create a char array for the bus routes (first n-1 chars)
        char[] buses = new char[n - 1];
        for (int i = 0; i < n - 1; i++) {
            buses[i] = args[i].charAt(0);
        }

        // Last char is the bus Serena is waiting for
        char targetBus = args[n - 1].charAt(0);

        // Find the position of the target bus
        for (int i = 0; i < buses.length; i++) {
            if (buses[i] == targetBus) {
                System.out.println(i + 1); // Print position (1-indexed)
                return;
            }
        }

        // If the bus is not found, print -1
        System.out.println("-1");
    }
}
