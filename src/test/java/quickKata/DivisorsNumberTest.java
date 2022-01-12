package quickKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DividerTests {

    DivisorsNumber fd = new DivisorsNumber();

    @Test
    public void oneTest() {
        assertEquals(3, fd.numberOfDivisors(25));
    }

    @Test
    public void fourTest() {
        assertEquals(3, fd.numberOfDivisors(4));
    }

    @Test
    public void fiveTest() {
        assertEquals(2, fd.numberOfDivisors(5));
    }

    @Test
    public void twelveTest() {
        assertEquals(6, fd.numberOfDivisors(12));
    }

    @Test
    public void thirtyTest() {
        assertEquals(8, fd.numberOfDivisors(30));
    }
}