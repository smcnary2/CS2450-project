## Project Description:

#### As a user the program will first pull up a file selection window. The user will choose a file that contains basicML commands. Then the program will run through the file and perform the commands listed.

#### The program has three classes: Main, Machine, and Memory. The Main class creates a machine object, and uses JFileChooser to prompt the user to choose a file. Afterwhich Machine calls two of its methods parse and run. Parse organizes the file into a readable format for the run function. Run goes through each basicML command and calls a use case depending on the contents of the command. The function of each use case is described below

## Use Cases:
### Use Case 1: Add
#### Actor: Student
#### System: UVSim program
#### Goal: The student will use the add operator to add a word from the accumulator with a word from memory, and store the results in the accumulator.

### Use Case 2: Subtract
#### Actor: Student
#### System: UVSim program
#### Goal: The student will use the subtract operator to subtract a word from the accumulator with a word from memory, and store the results in the accumulator.

### Use Case 3: Multiply
#### Actor: Student
#### System: UVSim program
#### Goal: The student will use the multiply operator to multiply a word from the accumulator with a word from memory, and store the results in the accumulator.

### Use Case 4: Divide
#### Actor: Student
#### System: UVSim program
#### Goal: The student will use the divide operator to divide a word from the accumulator with a word from memory, and store the results in the accumulator.

### Use Case 5: Write a word from memory to screen
#### Actor: Student
#### System: UVSim program
#### Goal: The student will be able to write a word from memory into the screen.


### Use Case 6: Read from input to a location in memory
#### Actor: Student
#### System: UVSim program
#### Goal: The student will be able to (upon input request from program) read word from screen in to a location in memory.

### Use Case 7: Load word from memory to accumulator
#### Actor: Student
#### System: UVSim program
#### Goal: The student will be able to store word from memory into the accumulator

### Use Case 8: Store word from accumulator to memory
#### Actor: Student
#### System: UVSim program
#### Goal: The student will be able to store word from accumulator into memory

### Use Case 9: Branch to a location in memory
#### Actor: Student
#### System: UVSim program
#### Goal: The student will be able to branch to a specific location in memory

### Use Case 10: Halt program
#### Actor: Student
#### System: UVSim program
#### Goal: The student will be able to choose to halt execution, being able to stop the program.
 
