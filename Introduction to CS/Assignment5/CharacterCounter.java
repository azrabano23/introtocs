/**
 * CharacterCounter
 * 
 * 1. This program reads in characters from a file (args[0]) and keeps
 *    track (using an array of size 128) of the number of times each character appears in a file.
 * 2. Then, the program writes to the output file (args[1]) from index 32 to 126 inclusive:
 *    [character],[ascii value],[number of times the character appears in the file],[frequency]
 * 
 * @author Mary Buist
 * @author Anna Lu
 */
public class CharacterCounter {

    public static void main(String[] args) {
        // Check if two arguments are provided
        if (args.length < 2) {
            System.out.println("Usage: java CharacterCounter <inputfile> <outputfile>");
            return;
        }

        // Initialize an array to count occurrences of each character
        int[] charCount = new int[128];
        int totalCharacters = 0;

        // Open the input file for reading
        StdIn.setFile(args[0]);

        // Read characters from the input file
        while (StdIn.hasNextChar()) {
            char c = StdIn.readChar();
            charCount[c]++;
            totalCharacters++;
        }

        // Open the output file for writing
        StdOut.setFile(args[1]);

        // Write to the output file for characters from index 32 to 126 inclusive
        for (int i = 32; i <= 126; i++) {
			double frequency = (charCount[i] / (double) totalCharacters) * 100;
			StdOut.printf("%c,%d,%d,%.2f%n", i, i, charCount[i], frequency);
        }
    }
}
