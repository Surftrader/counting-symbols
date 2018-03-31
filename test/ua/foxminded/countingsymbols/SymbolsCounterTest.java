package ua.foxminded.countingsymbols;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SymbolsCounterTest {
    
    private SymbolsCounter sc = new SymbolsCounter();
    
    private String text = "hello world!";    

    @Test
    public void shouldReturnCounterOfSymbolsWhichMeetInText() {        
        
        sc.setText(text);
        String actual = sc.calculateCounterOfCharacters();
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
    public void shouldReturnValueFromCache() {       
        
        sc.setText(text);
        String expected = sc.calculateCounterOfCharacters();   

        sc.setText(text);
        sc.calculateCounterOfCharacters();
        
        String actual = SymbolsCounter.MAP_CACHE.get(text);
        
        assertEquals(expected, actual);
    }
   
    @Test
    public void shouldReturnSizeMapAfterTestTwoOfSameText() {
        
        sc.setText(text);
        sc.calculateCounterOfCharacters();
        sc.setText(text);
        sc.calculateCounterOfCharacters();
        
        int actual = SymbolsCounter.MAP_CACHE.size();
        int expected = 1;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldReturnSizeMapAfterTestTwoDifferentText() {
        
        sc.setText(text);
        sc.calculateCounterOfCharacters();
        sc.setText(text + text);
        sc.calculateCounterOfCharacters();
        
        int actual = SymbolsCounter.MAP_CACHE.size();
        int expected = 2;
        
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfTextIsNull() {
        sc.setText(null);
        sc.calculateCounterOfCharacters();
    }
}
