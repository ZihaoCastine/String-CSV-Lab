package io.zipcoder.iotools;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zihaocastine on 5/22/16.
 */
public class MyStringUtilsTest {
    @Test
    public void charArrayToStringTest(){
        char [] chars={'a','b','c','d'};
        String expectedString="abcd";
        String actualString=MyStringUtils.arrayToString(chars);
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void stringArrayToStringTest(){
        String [] strings={"abc","efg"};
        String expectedString="abcefg";
        String actualString=MyStringUtils.arrayToString(strings);
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void stringsToArrayTest(){
        String s="abc\nbet\nidk";
        String [] expectedStrings={"abc","bet","idk"};
        String [] actualStrings=MyStringUtils.stringsToArray(s);
        Assert.assertArrayEquals(expectedStrings,actualStrings);

    }

    @Test
    public void reverseCapitalizeTest(){
        String s="I'm all about sysout";
        String expectedString="M'I LLA TUOBA TUOSYS";
        String actualString=MyStringUtils.reverseCapitalize(s);
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void reverseWordsTest(){
        String s="Eminem is the best rapper";
        String expectedString="menimE si eht tseb reppar";
        String actualString=MyStringUtils.reverseWord(s);
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void removeWhiteSpaceTest(){
        String s="Breaking  bad ";
        String expectedString="Breakingbad";
        String actualString=MyStringUtils.removeWhiteSpace(s);
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void everySubstringTest(){
        String s="abc ed";
        String [] expectedStrings={"a","ab","abc","b","bc","c","e","ed","d"};
        String []actualStrings=MyStringUtils.everySubstring(s);
        Assert.assertArrayEquals(expectedStrings,actualStrings);
    }


}
