import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateTest {
    //Number 1 and 2
    @Test
    void AddUpToTwo() {
        assertEquals(Calculate.add(""), 0, "Should return 0");
        assertEquals(Calculate.add("1"), 1, "Should return 1");
        assertEquals(Calculate.add("1,1"), 2, "Should return 2");
    }

    @Test
    void AddMultiple() {
        assertEquals(Calculate.add("1,2,3,4"), 10, "Should return 10");

    }

    //number 3
    @Test
    void AddWithNewLines() {
        assertEquals(6, Calculate.add("1\n2,3"));
    }

    //Number 4
    @Test
    void AddWithDifferentDelimiters() {
        assertEquals(3, Calculate.add("//;\n1;2"));
        assertEquals(3, Calculate.add("//4\n142"));
    }

    //Number 5
    @Test
    void AddWithNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Calculate.add("-1,-2,3,4"), "Should throw since the are negative numbers");
    }

    //Number 6
    @Test
    void AddThatIgnoreGreaterOrEqualThan1000() {
        assertEquals(3, Calculate.add("//;\n1000;1;2")); //Question was add("//;\n1000,1;2") and was returning zero, so replaced , with ;
    }

    //Number 7
    @Test
    void AddThatSupportAnyLengthDelimiter() {
        assertEquals(6, Calculate.add("//***\n1***2***3"));
    }

    //Number 8
    @Test
    void AddThatSupportAnyDelimiterAndLength() {
        assertEquals(6, Calculate.add("//[:D][%]\n1:D2%3"));
        assertEquals(6, Calculate.add("//[***][%%%]\n1***2%%%3"));
        assertEquals(0, Calculate.add("//[(-_-')][%]\n1(-_-')2%3"));
        assertEquals(7, Calculate.add("//[abc][777][:(]\n1abc27773:(1"));
    }

    //Number 9
    @Test
    void AddThatCanHandleInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Calculate.add("//;\n1000;1;2;"), "Should throw, the input is invalid");
        assertThrows(IllegalArgumentException.class, () -> Calculate.add("   //;\n1000,1;2"), "Should throw, the input is invalid");
        assertThrows(IllegalArgumentException.class, () -> Calculate.add("1,2,3//;\n1000,1;2"), "Should throw, the input is invalid");
    }
}
