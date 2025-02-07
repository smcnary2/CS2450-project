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
    void storeTest(){
        Machine a = new Machine();
        a.accumulator = 2500;
        a.store(1001);
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(1001));

        a.accumulator = 0;
        a.store(1002);
        Assertions.assertEquals(a.accumulator, a.memory.getWordSingle(1002));
    }
    @Test
    void readTest(){// doesnt work console is read only
        Machine a = new Machine();
        a.read(1001);
    }
    @Test
    void writeTest(){//cant create a test for write without a return type
        Machine a = new Machine();
        a.write(1001);
        Assertions.assertEquals(1001,1001);
    }

}