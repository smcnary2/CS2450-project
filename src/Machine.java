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
                    store();
                    break;
                case 30:
                    //add
                    break;
                case 31:
                    //subtract
                    break;
                case 32:
                    //divide
                    break;
                case 33:
                    //multiply
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
        System.out.println("Loaded " + accumulator+" into accumulator");

    }

    //read(
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
        int word = memory.getWordSingle(Math.abs(location%100));
        if(word == NULL){//
            System.out.print("location in memory is NULL");
        }else{
            System.out.println("location in memory: " + word);
        }

    }
    //parse
    public void parse(String input){
        //currently listed as a parse(filename)
        //could be easier as a parse(File) where File is a java File object
        //This would make it easier to select a file when running in main
        //but hey thats just my silly opinion
        //-Austin

        //convert string to int
    }

    //store
    public void store(){
        if(accumulator == 0){
            System.out.print("The accumulator is empty, cannot store");
        }else{
            int index= accumulator%100;
            if(index <0){
                index = Math.abs(index);
            }
            memory.setWordSingle(index, accumulator);
        }
    }

    //add
    public void add(int location1, int location2){

    }

    //subtract
    public void subtract(int location1, int location2){

    }

    //divide
    public void divide(int location1, int location2){

    }
    //multiply
    public void multiply(int location1, int location2){

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
