package com.improve10x.nameinverter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class NameInverterTest {
    NameInverter nameInverter;

    @BeforeEach
    public void setup(){
        nameInverter = new NameInverter();
    }
    @Test
    public void nothing(){
    }

    // inputString  = "", output = ""
    @Test
    public void givenEmpty_returnEmpty(){
        String invertedName = nameInverter.invertName("");
        assertEquals("", invertedName);
    }

    // input = "name", output = "name"
    @Test
    public void givenSingleWord_returnSingleWord(){
        String invertedName = nameInverter.invertName("name");
        assertEquals("name", invertedName);
    }

    @Test
    public void givenSingleWordWithTrailingSpaces_returnSingleWord(){
        String invertedName = nameInverter.invertName("name   ");
        assertEquals("name", invertedName);
    }

    @Test
    public void givenSingleWordWithBeginningSpaces_returnSingleWord(){
        String invertedName = nameInverter.invertName("   name   ");
        assertEquals("name", invertedName);
    }

    @Test
    public void givenFirstLast_returnsInvertedName(){
        String invertedName = nameInverter.invertName("first last");
        assertEquals("last, first", invertedName);
    }

    @Test
    public void givenHonorifics_ignoreHonorifics(){
        String invertedName = nameInverter.invertName("Mrs. first last");
        assertEquals("last, first", invertedName);
    }

    @Test
    public void givenMrHonorifics_ignoreHonorifics(){
        String invertedName = nameInverter.invertName("Mr. first last");
        assertEquals("last, first", invertedName);
    }

    @Test
    public void givenPostNominals_stayAtEnd(){
        String invertedName = nameInverter.invertName("first last MSc.");
        assertEquals("last, first MSc.", invertedName);
    }

    @Test
    public void givenMultiPostNominals_stayAtEnd(){
        String invertedName = nameInverter.invertName("first last MSc. PhD.");
        assertEquals("last, first MSc. PhD.", invertedName);
    }

    @Test
    public void integrationTest(){
        String invertedName = nameInverter.invertName("Mr. Bob Martins MTech. PhD.");
        assertEquals("Martins, Bob MTech. PhD.", invertedName);
    }
}
