import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.Scanner;

import static java.sql.Types.NULL;

public class Machine {
    //constructor: builds memory
    Memory memory;
    int accumulator = 0;
    Scanner scanner = new Scanner(System.in);
    public Machine(){
        memory = new Memory();
    }
    //run
    public void run(){
        //while loop
        boolean finished = false;
        accumulator = 0;
        int index = 0;
        while(!finished){
            int command = memory.getWordSingle(index);
            switch(command / 100){
                case 10:
                    //read
                    read(command);
                    break;
                case 11:
                    //write
                    write(command);
                    break;
                case 20:
                    //load
                    load(command);
                    break;
                case 21:
                    //store
                    store(accumulator);
                    break;
                case 30:
                    //add
                    add(index);
                    break;
                case 31:
                    //subtract
                    subtract(index);
                    break;
                case 32:
                    //divide
                    divide(index);
                    break;
                case 33:
                    //multiply
                    multiply(index);
                    break;
                case 40:
                    //branch
                    break;
                case 41:
                    //branchneg
                    break;
                case 42:
                    //branchzero
                    break;
                case 43:
                    //halt
                    System.out.println("Halt reached Successfully");
                    finished = true;
                    break;
                default:
                    System.out.println("Reached invalid line");
                    finished = true;
                    //invalid input
            }
            //finished = true; //for testing purposes I've closed this loop until we begin actually developing it (Austin Pendley 2/1/2025)
            index++;
        }
    }
    //load
    public void load(int i){
        //add the number to the accumulator
        accumulator = i;

    }

    //read
    public void read(int i){
        boolean conintueloop = true;
        while(conintueloop) {
            System.out.print("Enter a word(4-digit number):");
            int word = scanner.nextInt();
            //error trap var word
            if (String.valueOf(word).length() != 4) {//if not valid input(less than length 4):
                System.out.println("Invalid word");
                conintueloop = true;//prompt another number
            } else {//if valid input:
                memory.setWordSingle(i, word);
                conintueloop = false;//send it to memory class
            }

        }

    }
    //write
    public void write(int location){
        if(location == NULL){//
            System.out.print("location in memory is NULL");
        }else{
            System.out.println("location in memory: " + location);
        }

    }
    //parse
    public void parse(File file) throws FileNotFoundException {
        //currently listed as a parse(filename)
        //could be easier as a parse(File) where File is a java File object
        //This would make it easier to select a file when running in main
        //but hey thats just my silly opinion
        //-Austin
        //convert string to int
        int word_size = 4;
        int min_value = -9999;
        int max_value = 9999;
        int index = 0;
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine() && index < 100) {
            String line = scanner.nextLine().trim(); //parse through each line
            try {
                int value = Integer.parseInt(line); // convert a string in line as ints
                if (value >= min_value && value <= max_value) {
                    memory.setWordSingle(index, value);
                } else {
                    // catches words longer than 4 numbers
                    System.err.println("Invalid word size (not " + word_size + ") at index " + index);
                }
            } catch (NumberFormatException e) {
                // catches words that are not numbers
                System.err.println("Error parsing line " + index + ": " + line);
            }
            index++;
        }
        scanner.close();
    }

    //store
    public void store(int location){
        if(accumulator == 0){
            System.out.print("The accumulator is empty, cannot store");
        }else{
            memory.setWordSingle(accumulator, location%100);
        }
    }


    public void add(int mem_index){
        //add - adds word from location in memory with accumulator
        // leaves result in accumulator
        accumulator += mem_index;
    }


    public void subtract(int mem_index){
        //subtract - subtracts word from location in memory with accumulator
        // leaves result in accumulator
        accumulator -= mem_index;
    }


    public void divide(int mem_index){
        //divide - divides word from location in memory with accumulator
        // leaves result in accumulator
        accumulator /= mem_index;
    }

    public void multiply(int mem_index){
        //multiply - multiplies word from location in memory with accumulator
        // leaves result in accumulator
        accumulator *= mem_index;
    }
    //branch
    public void branch(){

    }

    //branchneg
    public void branchneg(){

    }
    //branchzero
    public void branchzero(){

    }
    //halt
    public void halt(){

    }

    //set(only for testing)
    //get(only for testing)
}
