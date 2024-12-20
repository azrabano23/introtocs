/*
 * Write your program inside the main method to compute the 
 * Gravitational Force according to the assignment description.
 * 
 * To compile:
 *        javac GravitationalForce.java
 * To execute:
 *        java GravitationalForce 36000.0 1080.0 50.0
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */

public class GravitationalForce {

    public static void main(String[] args) {
                // Constant for gravitational constant (in m^3 kg^-1 s^-2)
                double G = 6.6743e-11;
        
                // Parse the command line arguments to double values
                double m1 = Double.parseDouble(args[0]); // Mass of object 1
                double m2 = Double.parseDouble(args[1]); // Mass of object 2
                double r = Double.parseDouble(args[2]);  // Distance between the objects
        
                // Calculate the gravitational force
                double force = G * (m1 * m2) / (r * r);
        
                // Display the result
                System.out.println(force);
    }
}
