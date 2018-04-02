package ua.foxminded.countingsymbols;

import static org.junit.Assert.*;

import org.junit.Test;

public class SymbolsCounterTest {

    @Test
    public void shouldReturnCounterOfSymbolsWhichMeetInText() {
        SymbolsCounter sc = new SymbolsCounter();
        String actual = sc.countChars("hello world!");
        String expected = 
                          "hello world!\n"
                        + "\"h\" - 1\n" 
                        + "\"e\" - 1\n" 
                        + "\"l\" - 3\n" 
                        + "\"o\" - 2\n"
                        + "\" \" - 1\n" 
                        + "\"w\" - 1\n" 
                        + "\"r\" - 1\n" 
                        + "\"d\" - 1\n" 
                        + "\"!\" - 1\n";

        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldReturnStartingStringWhithResultCountSymbols() {
        SymbolsCounter sc = new SymbolsCounter();
        String actual = sc.countChars("hello world!\n"
                + "\"h\" - 1\n"
                + "\"e\" - 1\n"
                + "\"l\" - 3\n"
                + "\"o\" - 2\n"
                + "\" \" - 1\n"
                + "\"w\" - 1\n"
                + "\"r\" - 1\n"
                + "\"d\" - 1\n"
                + "\"!\" - 1\n"
                );
        String expected = 
                "hello world!\n"
                + "\"h\" - 1\n"
                + "\"e\" - 1\n"
                + "\"l\" - 3\n"
                + "\"o\" - 2\n"
                + "\" \" - 1\n"
                + "\"w\" - 1\n"
                + "\"r\" - 1\n"
                + "\"d\" - 1\n"
                + "\"!\" - 1\n"
                + "\n"
                + "\"h\" - 2\n"
                + "\"e\" - 2\n"
                + "\"l\" - 4\n"
                + "\"o\" - 3\n"
                + "\" \" - 20\n"
                + "\"w\" - 2\n"
                + "\"r\" - 2\n"
                + "\"d\" - 2\n"
                + "\"!\" - 2\n"
                + "\"\n"
                + "\" - 10\n"
                + "\"\"\" - 18\n"
                + "\"-\" - 9\n"
                + "\"1\" - 7\n"
                + "\"3\" - 1\n"
                + "\"2\" - 1\n";
        
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnResultStringFromCache() {
        SymbolsCounter sc = new SymbolsCounter();
        String actual = sc.countChars("hello world!");
        String expected = sc.countChars("hello world!");

        assertSame(expected, actual);
    } 

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfTextIsNull() {
        SymbolsCounter sc = new SymbolsCounter();
        sc.countChars(null);
    }
}
