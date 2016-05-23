package io.zipcoder.iotools;

import java.util.ArrayList;

/**
 * Created by zihaocastine on 5/22/16.
 */
public class MyStringUtils {
    public static String arrayToString(char charArray[]){

        return new String(charArray);
    }

    public static String arrayToString(String stringArray[]){
        StringBuilder builder=new StringBuilder();
        for(String each: stringArray){
            builder.append(each);
        }
        return builder.toString();
    }

    public static String [] stringsToArray(String s){
        String [] strings=s.split("\n");
        return strings;
    }

    public static String reverseCapitalize(String s){
        StringBuilder stringReverse=new StringBuilder();
        String [] strings=s.split(" ");
        for(String each: strings){
            stringReverse.append(reverse(each).toUpperCase()).append(" ");
        }
        return  stringReverse.toString().trim();
    }

    public static String reverseWord(String s){
        StringBuilder stringReverse=new StringBuilder();
        String [] strings=s.split(" ");
        for(String each: strings){
            stringReverse.append(reverse(each)).append(" ");
        }
        return  stringReverse.toString().trim();
    }

    private static String reverse(String s){
        StringBuilder stringBuilder=new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }

    public static String removeWhiteSpace(String s){
        StringBuilder stringBuilder=new StringBuilder();
        String [] strings=s.split(" ");
        for(String each: strings){
            stringBuilder.append(each);
        }
        return  stringBuilder.toString();
    }

    public static String [] everySubstring(String s){
        String [] strings=s.split(" ");
        ArrayList<String> stringList=new ArrayList<String>();
        for(String each: strings){
            for(int i=0; i<=each.length();i++){
                for(int j=i; j<each.length();j++){
                    String subString=each.substring(i,j+1);
                    if(!stringList.contains(subString)&& !subString.equals(" ")){
                        stringList.add(subString);
                        System.out.println(subString);
                    }
                }
            }
        }
        return stringList.toArray(new String[stringList.size()]);

    }


}
