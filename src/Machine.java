public class Machine {
    //constructor: builds memory
    Memory memory;
    int accumulator = 0;
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
                    break;
                case 11:
                    //write
                    break;
                case 20:
                    //load
                    break;
                case 21:
                    //store
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

    //read(
    public void read(int i){

    }
    //write
    public void write(int location){

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
    public void store(int location){

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
