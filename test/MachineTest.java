import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MachineTest {

    @Test
    void runHaltTest(){
        Machine a = new Machine();
        a.memory.setWordSingle(0, 4300);
        a.run();
    }

    @Test
    void runScriptTest(){
        //testing whether valid code will break the code
        Machine a = new Machine();
        a.memory.setWordSingle(0, 3000);
        a.memory.setWordSingle(1, 3100);
        a.memory.setWordSingle(2, 3200);
        a.memory.setWordSingle(3, 3301);
        a.memory.setWordSingle(4, 4300);
        a.run();
    }
    @Test
    void readTest(){
        Machine a = new Machine();
        // Simulating System.in for testing
        String word = "+1023";
        InputStream inputStream = new ByteArrayInputStream(word.getBytes());
        Scanner scanner = new Scanner(inputStream);

        a.read(23,scanner);
        Assertions.assertEquals(1023, a.memory.getWordSingle(23));


    }
    @Test
    void readNegPosTest(){
        Machine a = new Machine();
        String word = "-1023";
        InputStream inputStream = new ByteArrayInputStream(word.getBytes());
        Scanner scanner = new Scanner(inputStream);
        a.read(23,scanner);
        Assertions.assertEquals(-1023, a.memory.getWordSingle(23));
    }
    @Test
    void loadTest(){
        Machine a = new Machine();
        a.memory.setWordSingle(1, 3000);
        a.load(01); //location will be written as a 2 digit location, will load that word into accumulator
        Assertions.assertEquals(3000, a.accumulator);
    }
    @Test
    void loadTestExtended(){
        Machine a = new Machine();
        a.memory.setWordSingle(0, 3000);
        a.load(0);
        Assertions.assertEquals(3000, a.accumulator);
        a.memory.setWordSingle(1, 3100);
        a.memory.setWordSingle(2, 3200);
        a.memory.setWordSingle(3, 3301);

        a.load(1);
        a.load(2);
        a.load(3);
        Assertions.assertEquals(3301, a.accumulator);
    }
    @Test
    void storeTest(){
        Machine a = new Machine();
        a.accumulator = 2500;
        a.store(01);
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(01));

        a.accumulator = 0;
        a.store(02);
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(02));
    }
    @Test
    void storeNegPosTest(){
        Machine a = new Machine();
        a.accumulator = +2500;
        a.store(00);
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(0));

        a.accumulator = -2501;
        a.store(01);
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(1));
    }


    @Test
    void writeTest(){//cant create a test for write without a return type
        Machine a = new Machine();
        boolean result1 = a.write(01);
        Assertions.assertEquals(true, result1);
    }
    void writeTestNeg(){
        Machine a = new Machine();
        boolean result1 = a.write(-1);
        Assertions.assertEquals(true,result1);
    }

    @Test
    void sumTest(){
        Machine a = new Machine();
        a.memory.setWordSingle(90, 423);//variable 1
        a.memory.setWordSingle(91, 201);//variable 2
        a.memory.setWordSingle(0, 3090);//add variable 1 to accumulator
        a.memory.setWordSingle(1, 3091);//add variable 2 to accumulator
        a.memory.setWordSingle(2, 2199);//store accumulator in memory 99
        a.memory.setWordSingle(3, 4300);//halt
        a.run();
        Assertions.assertEquals(3090, a.memory.getWordSingle(0));
        Assertions.assertEquals(624, a.accumulator);
        Assertions.assertEquals(624, a.memory.getWordSingle(99));
    }

    @Test
    void branchTest(){
        Machine a = new Machine();
        a.memory.setWordSingle(0, 4002);//skip to line 2
        a.memory.setWordSingle(1, 3000);//add the value of line zero (should be skipped)
        a.memory.setWordSingle(2, 4300);//halt
        a.run();
        Assertions.assertEquals(0, a.accumulator);
    }

    @Test
    void branchNegTest(){
        Machine a = new Machine();
        a.memory.setWordSingle(90, 20);//var1
        a.memory.setWordSingle(91, -50);//var2
        a.memory.setWordSingle(0, 4104);//if neg branch to 4 (should not branch)
        a.memory.setWordSingle(1, 3091);//add -50 to accumulator
        a.memory.setWordSingle(2, 4104);//if neg branch to 4 (should branch)
        a.memory.setWordSingle(3, 3090);//add 20 to accumulator (should be skipped)
        a.memory.setWordSingle(4, 4300);//halt
        a.run();
        Assertions.assertEquals(-50, a.accumulator);
    }

    @Test
    void branchZeroTest(){
        Machine a = new Machine();
        a.memory.setWordSingle(90, 1111);//var1
        a.memory.setWordSingle(0, 4202);//jump to line 2 if zero
        a.memory.setWordSingle(1, 3090);//add var1 to accumulator (should be skipped)
        a.memory.setWordSingle(2, 4300);//halt
        a.run();
        Assertions.assertEquals(0, a.accumulator);
    }

}
