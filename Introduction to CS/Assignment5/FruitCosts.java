/**
 * FruitCosts 
 * 
 * 1. This program reads in a list of fruits and their costs from a file (args[0]).
 * 2. Then finds the two lowest cost fruits and prints their names and costs
 * along with the total cost.
 * 
 * @author Srimathi Vadivel
 * @author Sarah Benedicto
 */
public class FruitCosts {
    /**
     * Main function to execute the program
     * 
     * @param args command-line arguments, where args[0] is the file name to read from
     */
    public static void main(String[] args) {

        // Do not remove this line, it opens the file for reading.
        StdIn.setFile(args[0]);

        // Read the number of fruits
        int nbrFruits = StdIn.readInt();
        String[] fruitNames = new String[nbrFruits];
        double[] fruitCosts = new double[nbrFruits];

        // Read fruit names and costs into parallel arrays
        for (int i = 0; i < nbrFruits; i++) {
            fruitNames[i] = StdIn.readString(); // Read the fruit name
            fruitCosts[i] = StdIn.readDouble(); // Read the fruit cost
        }

        // Initialize indices for the two lowest costs
        int firstIndex = 0;
        int secondIndex = 1;

        // Ensure the first index is the lower of the first two costs
        if (fruitCosts[secondIndex] < fruitCosts[firstIndex]) {
            int tempIndex = firstIndex;
            firstIndex = secondIndex;
            secondIndex = tempIndex;
        }

        // Iterate through the rest to find the two lowest costs
        for (int i = 2; i < nbrFruits; i++) {
            if (fruitCosts[i] < fruitCosts[firstIndex]) {
                secondIndex = firstIndex;
                firstIndex = i;
            } else if (fruitCosts[i] < fruitCosts[secondIndex]) {
                secondIndex = i;
            }
        }

        // Calculate total cost
        double totalCost = fruitCosts[firstIndex] + fruitCosts[secondIndex];

        // Print the results in the specified format
        System.out.printf("%s %.2f%n", fruitNames[firstIndex], fruitCosts[firstIndex]);
        System.out.printf("%s %.2f%n", fruitNames[secondIndex], fruitCosts[secondIndex]);
        System.out.printf("Total %.2f%n", totalCost);
    }
}
