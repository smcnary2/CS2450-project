import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryTest {

    @Test
    void MemSingleTest(){
        int a = 2;
        Memory testmem = new Memory();
        testmem.setWordSingle(0, a);
        assertTrue(testmem.getWordSingle(0) == a); //set memory should equal get memory
    }

    @Test
    void MemWordListTest(){
        int[] b = new int[100];
        for(int x : b){
            x = 55; //giving each word in memory a nonzero value
        }
        Memory testmem = new Memory();
        testmem.setWordlist(b);
        assertTrue(testmem.getWordlist() == b); //set memorylist should equal get memorylist
    }

}