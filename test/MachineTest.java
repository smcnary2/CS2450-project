import static org.junit.jupiter.api.Assertions.*;
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

}