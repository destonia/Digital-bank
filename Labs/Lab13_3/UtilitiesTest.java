package Lab13_3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {
    private Utilities util;
    @Before
    public void setup(){
        util = new Utilities();
    }
    @Test
    public void everyNthChar() {
        char[] output = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output);
        char[] output2 = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @Test
    public void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDEFF"));
        assertEquals("ARGHBG", util.removePairs("AARGGHBGG"));
    }

    @Test
    public void converter() {
        assertEquals(300, util.converter(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() throws Exception {
        util.converter(10, 0);
    }

    @Test
    public void nullIfOddLength() {
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}