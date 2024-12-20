
/*************************************************************************
 *  Compilation:  javac Elevator.java
 *  Execution:    java Elevator 'number of floors' 'floor requests' 'number of restricted floors' 'optional passcode'
 *
 *  @author Pooja Kedia
 *  @author Vidushi Jindal
 *
 *************************************************************************/
public class Elevator {

    public static void main(String[] args) {
        int totalFloors = Integer.parseInt(args[0]);
        int floorRequests = Integer.parseInt(args[1]);
        int restrictedFloors = Integer.parseInt(args[2]);
        int password = args.length > 3 ? Integer.parseInt(args[3]) : -1;

        int elevator1 = 1;  // Elevator 1 starts at floor 1
        int elevator2 = 1;  // Elevator 2 starts at floor 1
        int request;

        while (floorRequests > 0) {
            request = floorRequests % 10;  // Get the rightmost floor request
            floorRequests /= 10;           // Remove the last digit

            // Check if the requested floor is restricted
            boolean isRestricted = request > (totalFloors - restrictedFloors);
            boolean accessGranted = false;

            if (isRestricted) {
                if (password != -1 && (password % totalFloors == request ||
                        (password % totalFloors == 0 && request == totalFloors))) {
                    accessGranted = true;
                }
            }

            // Determine which elevator is closer to the requested floor
            int distance1 = Math.abs(elevator1 - request);
            int distance2 = Math.abs(elevator2 - request);

            if (distance1 <= distance2) {
                System.out.println("1 " + request);
                elevator1 = request;  // Move elevator 1 to the requested floor
                if (isRestricted && accessGranted) {
                    System.out.println("Granted");  // Print granted after servicing
                }else if(isRestricted){
                    System.out.println("Denied");
                }
            } else {
                System.out.println("2 " + request);
                elevator2 = request;  // Move elevator 2 to the requested floor
                if (isRestricted && accessGranted) {
                    System.out.println("Granted");  // Print granted after servicing
                }else if(isRestricted){
                    System.out.println("Denied");
                }
            }
        }
    }
}