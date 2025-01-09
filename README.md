# Java Programs
All programs have been coded in Java. 
To access the code, please ensure you open the .java files.

# Assignment 2

Gravitational Force: The GravitationalForce.java program calculates the gravitational force between two objects using their masses and the distance between them. The program takes three double values as command-line arguments, performs the computation, and displays the result.
Skills Used: Mathematical Computation, Command-Line Argument Parsing, Double Data Type Handling, Basic Arithmetic Operations, Precision Output Formatting

Palindrome: The Palindrome.java program checks whether six integers provided as command-line arguments form a palindrome pattern. A phrase is a palindrome if it reads the same forward and backward. It uses a boolean expression to verify if the first equals the last, the second equals the second-to-last, and the third equals the third-to-last, printing true if all conditions are met and false otherwise. 
Skills Used: Command-Line Argument Parsing, Integer Data Type Handling, Boolean Expressions, Logic Evaluation, Symmetry Detection in Data


# Assignment 3

Floor is Lava: The FloorIsLava.java program simulates a sequence of safe spaces (stones) and dangerous spaces (lava) based on an input integer. It first prints all even numbers up to the input in ascending order (representing stones), then switches to print odd numbers in descending order (representing the reversed lava/stone state). 
Skills Used: Command-Line Argument Parsing, Control Flow, Modulus Operations, Ascending/Descending Sorting, Looping for Data Generation, Basic Algorithm Design

Elevator: The Elevator.java program simulates the operation of two elevators servicing floor requests in a building, considering proximity and priority rules. It determines which elevator services each request and handles restricted floors by validating access through an optional passcode. The program efficiently processes multiple requests, prioritizes Elevator 1 in case of ties, and outputs the elevator servicing each floor and whether access to restricted floors is granted or denied.
Skills Used: Queue Simulation, Proximity Calculation, Conditional Logic for Priority, Modulus Operations for Passcode Validation, Data Processing and Decision Making, Multi-Object State Tracking

# Assignment 4

BusStop: The BusStop.java program determines the arrival order of buses at a stop based on a sequence of bus route names provided as input. It identifies when Serena’s desired bus will arrive or returns -1 if the bus does not stop there. The program uses a 1D array and looping techniques to search for the specified bus efficiently.
Skills Used: Array Handling, Character Data Manipulation, Looping for Searching, Conditional Logic, Input Validation, Index-Based Operations

Egyptian Pyramid: The EgyptianPyramid.java program builds a 2D pyramid grid using a specified number of bricks (X) and fills the remaining spaces with = to represent empty spots. It constructs and prints the pyramid using a 2D array, updating the grid dynamically based on the number of bricks provided. The program also outputs the number of unused bricks after the pyramid construction.
Skills Used: 2D Array Manipulation, Nested Looping, Grid Construction Logic, Character Data Representation, Conditional Statements, Output Formatting

# Assignment 5

Fruit Costs: The FruitCosts.java program reads a list of fruits and their costs from an input file, identifies the two lowest-cost fruits, and calculates their total cost. Using 1D parallel arrays, the program efficiently stores and processes the fruit names and their corresponding prices.
Skills Used: File Input Handling with StdIn, 1D Parallel Arrays, Looping and Iteration, Sorting and Minimum Selection. String and Numeric Data Handling, Arithmetic Operations, Output Formatting, 

Character Counter: The CharacterCounter.java program counts the occurrences of each character in a file and calculates their frequencies using a 1D integer array. The program processes ASCII characters, focusing on printable values (32–126), and writes the results to an output file in a specific format. 
Skills Used: File Input/Output Handling with StdIn and StdOut, 1D Arrays for Frequency Counting, ASCII Character Handling, Looping and Iteration, Data Casting Between char and int, Percentage and Frequency Calculation, Output File Formatting

# Assignment 6

Matryoshka Doll: The Matryoshka.java program simulates the creation of Russian nesting dolls using recursion and iterative functions. It features a stackDolls() recursive method to draw a series of adjacent, progressively smaller dolls and a drawDoll() iterative method to render each doll with a head and body using StdDraw. 
Skills Used: Recursive Function Design, Iterative Graphics Drawing, StdDraw Library Usage, Geometric Shape Calculations, Command-Line Argument Parsing, Function Parameterization, Canvas-Based Rendering

Quadratic Koch: The QuadraticKoch.java program generates a fractal pattern, the Quadratic Koch Snowflake, using recursive and iterative methods. The koch() recursive function creates segments of the snowflake, while getCoords() calculates coordinates for each segment using geometric transformations. This project focuses on recursion, fractal geometry, and 2D graphical programming.
Skills Used: Recursive Function Design, Iterative Coordinate Calculation, StdDraw Library for Fractal Drawing, 2D Array Manipulation, Command-Line Argument Parsing, Fractal and Geometric Transformations, Visualization of Recursive Patterns

# Assignment 7

Solar Panel Consultant Project: The SolarPanels.java program simulates the process of planning, installing, and maintaining solar panel projects on Rutgers parking lots to optimize electricity generation and cost savings. It involves reading street maps and parking lot data, installing solar panels, updating their efficiency and electricity generation, and calculating Rutgers' yearly savings. This project focuses on array manipulation, 2D mapping, object-oriented programming, and energy efficiency calculations.

Skills Used: 
- 2D Array Manipulation: Handling a grid-like structure to represent street maps and solar panel placements.
Object-Oriented Programming: Using Panels and ParkingLot classes for modular and structured data handling.
- File I/O Operations: Reading and processing data from input files using StdIn.
- Simulation of Real-World Processes: Implementing logic to install, update, and maintain solar panels based on efficiency, budget, and capacity.
- Mathematical and Statistical Calculations: Calculating efficiency loss/gain, daily and yearly electricity generation, and financial savings.
- Recursion for Efficiency Updates: Recursive updates for energy efficiency loss or gains based on temperature.
- Randomized Simulation: Using StdRandom.uniform() to simulate the working status of solar panels.
- Data Validation and Conditional Logic: Ensuring panels are placed correctly and budgets are adhered to.
- Energy and Financial Optimization: Calculating Rutgers’ savings by comparing solar energy output with electricity needs.

Key Features of the Program

Setup Methods:
setupStreetMap: Reads and populates a 2D array representing the street map with parking lot and road data.
setupParkingLots: Creates an array of parking lot objects with budget, capacity, and panel efficiency information.

Panel Installation and Maintenance:
insertPanels: Installs panels in parking lots based on capacity, budget, and placement rules.
updateActualEfficiency: Updates panel efficiency based on temperature and environmental conditions.
updateElectricityGenerated: Calculates daily electricity generation for each panel.
countWorkingPanels: Counts the number of functional panels in a specific parking lot.
updateWorkingPanels: Repairs broken panels and returns the updated count of working panels.

Energy and Cost Savings:
calculateSavings: Computes annual savings based on solar panel electricity output relative to Rutgers’ energy consumption.

Randomized Simulation:
- Simulates the functionality of solar panels, considering a 95% chance of them working.

File Integration:
- Processes multiple input files containing map, lot, and panel data for seamless testing and simulation.

Real-World Applications
This project simulates a practical approach to renewable energy planning and cost savings in a large institution.
It provides insights into energy efficiency, resource allocation, and financial impact calculations.

# Assignment 8 

PlayMinesweeper: The PlayMinesweeper.java program simulates the classic Minesweeper game, incorporating its rules, mechanics, and features such as mine placement, safe square identification, flagging suspected mines, and recursive opening of squares. The program uses a 2D array of Square objects to represent the game grid, and players interact through text-based or graphical interfaces to navigate the minefield. 

Skills Used: 
- 2D Array Manipulation: Using a grid structure to represent the Minesweeper board and manage square states and mine locations.
- Object-Oriented Programming: Leveraging Square and State classes to encapsulate grid element properties and states.
- Recursion: Implementing recursive algorithms to open safe squares and propagate opening of adjacent empty squares.
- File I/O Operations: Reading and processing input files containing grid and mine placement data using StdIn.
- Game Mechanics Simulation: Mimicking Minesweeper rules, such as flagging, mine detection, and safe square identification.
- Conditional Logic and Validation: Ensuring appropriate game behaviors, such as preventing flags on open squares or verifying win conditions.
- Randomized Simulation: Using StdRandom to randomly generate mine placements for custom game boards.
- Graphical and Text-Based Testing: Interacting with the game using provided GraphicalDriver and TextDriver tools for debugging and simulation.

Key Features of the Program
Grid Initialization and Mine Placement:
placeMines: Sets up the game board by placing mines in specified locations and marking them on the grid.

Safe Square Identification:
fillGrid: Updates the grid with numbers indicating the count of neighboring mines for each safe square.

Recursive Square Opening:
openSquare: Implements recursive logic to open empty squares and adjacent safe squares while avoiding mines.

Flagging and Deflagging:
placeFlag: Adds or removes flags on suspected mine squares, updating the flag count accordingly.

Win Condition Check:
checkWinCondition: Validates whether all safe squares have been opened without detonating any mines.

Difficulty Levels and Randomized Boards:
chooseDifficulty: Configures the grid size and mine count based on difficulty levels (Beginner, Intermediate, Advanced).
playRandom: Randomly generates mines after the player’s first click, ensuring the first move is safe.

Game Simulation:
Full integration of Minesweeper gameplay, including opening squares, flagging mines, and progressing toward winning conditions.

Real-World Applications
This project demonstrates:
- Grid-based game design and logic implementation.
- Recursive problem-solving and state management.
- Interactive program development using graphical and text-based interfaces.

# Assignment 9 

RU Racing: The RURacing.java program simulates racers with different time complexities (O(1), O(log n), O(n), and O(n²)) completing laps on a raceway constructed from 2D maps. Racers' behaviors illustrate algorithmic efficiencies as they navigate the raceway, demonstrating how time complexity impacts task completion. 

Skills Used: 
- 2D Array Manipulation: Creating, updating, and navigating raceway maps using a character grid.
- Algorithm Runtime Analysis: Understanding and simulating different time complexities (O(1), O(log n), O(n), O(n²)).
- Simulation Design: Designing realistic racer behavior based on computational complexity.
- File I/O Operations: Reading track coordinates from input files using the StdIn library.
- Sliding Window Technique: Connecting raceway corners to form roads efficiently.
- Recursion and Looping: Iterative and recursive methods to navigate and modify 2D arrays.
- Big O Notation Concepts: Applying theoretical runtime analysis to practical scenarios.
- State Tracking: Maintaining racer positions and directions to avoid backtracking.
- Encapsulation: Using private helper methods for modular and maintainable code.

Key Features of the Program

Raceway Construction:
createRaceway: Builds a 2D grid map connecting raceway corners using straight roads.
drawRoad: Draws horizontal and vertical roads between specified points.

Racer Behavior:
racer1 (O(1)): Completes the track in a single step, demonstrating constant time complexity.
racer2 (O(log n)): Doubles its step size each time, illustrating logarithmic runtime.
racer3 (O(n)): Travels linearly through the raceway, printing each position it reaches.
racer4 (O(n²)): Stays at each position for n iterations, showing quadratic time complexity.

Visualization and Output:
printMap: Displays the raceway grid with grass and roads for visualization.
moveRacer: Updates the map with the racer's current position and direction while avoiding backtracking.

File Integration:
Reads track files containing raceway corner coordinates to construct the map dynamically.

Runtime and Performance Illustration:
Demonstrates the impact of algorithm efficiency on task completion time in a visually interactive manner.

Real-World Applications
This project highlights:
- The significance of runtime efficiency in algorithm design.
- Visualizing the impact of computational complexity through a practical simulation.
- Applying theoretical concepts (Big O notation) to realistic scenarios.
