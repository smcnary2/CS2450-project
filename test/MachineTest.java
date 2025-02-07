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
    void loadTest(){
        Machine a = new Machine();
        a.load(1001);
        Assertions.assertEquals(1001, a.accumulator);

    }
    @Test
    void loadNegPosTest(){
        Machine a = new Machine();
        a.load(-1001);
        Assertions.assertEquals(-1001, a.accumulator);

        a.load(+2002);
        Assertions.assertEquals(+2002, a.accumulator);
    }
    @Test
    void storeTest(){
        Machine a = new Machine();
        a.accumulator = 2525;
        a.store();
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(25));

        a.accumulator = 0;
        a.store();
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(1));
    }
    @Test
    void storeNegPosTest(){
        Machine a = new Machine();
        a.accumulator = +2500;
        a.store();
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(0));

        a.accumulator = -2501;
        a.store();
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(1));
    }

    @Test
    void writeTest(){//cant create a test for write without a return type
        Machine a = new Machine();
        a.write(1001);// empty
        Assertions.assertEquals(0,a.memory.getWordSingle(1));
    }
    @Test
    void writeNegPosTest(){
        Machine a = new Machine();
        a.memory.setWordSingle(0, -2501);
        a.write(-2501);
        Assertions.assertEquals(-2501, a.memory.getWordSingle(0));

        a.memory.setWordSingle(0, 2500);
        a.write(2500);
        Assertions.assertEquals(2500, a.memory.getWordSingle(0));
    }

}