package Lab13_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void everyNthChar() {
        fail("this method is not being implement");
    }

    @Test
    public void removePairs() {
        Utilities util = new Utilities();
        assertEquals("ABCDEF" , util.removePairs("AABCDEFF"));
        assertEquals("ARGHBG" , util.removePairs("AARGGHBGG"));
    }

    @Test
    public void converter() {
        fail("this method is not being implement");
    }

    @Test
    public void nullIfOddLength() {
        fail("this method is not being implement");
    }
}