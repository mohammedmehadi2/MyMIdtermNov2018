package string.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);
        System.out.println(wordNLength.keySet().iterator().next()+" "+wordNLength.entrySet().stream().findFirst().get().getValue());


    }


    public static Map<Integer, String> findTheLargestWord(String givenSentence){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        //implement
        String [] splittedword = givenSentence.split("\\s");
        for(int i = 0; i < splittedword.length; i++)
        {
            if(splittedword[i].length()>st.length()){
                st = splittedword[i];
            }
        }map.put(st.length(),st);

        return map;

    }
}
