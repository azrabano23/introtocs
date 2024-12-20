
/**
 * Compilation: javac EgyptianPyramid.java
 * Execution:   java EgyptianPyramid 'size of grid' 'number of initial blocks'
 * 
 * @author Ayla Muminovic
 * @author Kushi Sharma
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 */
public class EgyptianPyramid {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int bricks = Integer.parseInt(args[1]);
        char[][] pyramid = new char[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pyramid[i][j] = '='; 
            }
        }
        int starter = 0;
        for (int i = size - 1; i >= 0; i--) {
            
            for (int j = starter; j < size-starter; j++) {
                if (bricks > 0) {
                    pyramid[i][j] = 'X';
                    bricks--;
                }
            }
            starter++;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(pyramid[i][j]);
            }
            System.out.println();
        }

        // Print the remaining bricks message
        System.out.println(bricks +" Bricks Remaining");
    }   
}