import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {

    @Test
    void AddUpToTwo(){
        assertEquals(Calculate.add(""),0,"Should return 0");
        assertEquals(Calculate.add("1"),1,"Should return 1");
        assertEquals(Calculate.add("1,1"),2,"Should return 2");
    }

}
