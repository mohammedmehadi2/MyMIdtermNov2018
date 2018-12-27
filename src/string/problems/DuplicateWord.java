package string.problems;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by mrahman on 04/22/17.
 */
public class DuplicateWord {

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        System.out.println("Duplicate words are : "+dpliword(st)+"\nThey occur "+occur(st)+" times\nThe avarage length of the words are : "+avg(st));

    }

    public static Set<String> dpliword(String s) {



        if (s == null || s.isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> duplicateWords = new HashSet<>();

        String[] array = s.split(" ");

        Set<String> set = new HashSet<>();
        ArrayList<String> arraylist = new ArrayList<>();
        for (String word : array) {
            arraylist.add(word);
            if (!set.add(word)) {
                duplicateWords.add(word);
            }
        }
        return duplicateWords;

    }

    public static int occur(String w) {
        int occurence = 0;

        Set<String> duplicateWords = new HashSet<>();

        String[] array = w.split(" ");
        double avgLength = (double) w.length() / array.length;

        Set<String> set = new HashSet<>();
        ArrayList<String> arraylist = new ArrayList<String>();
        for (String word : array) {
            arraylist.add(word);
            if (!set.add(word)) {
                duplicateWords.add(word);
            }
        }
        for (String word : duplicateWords) {
            if (Collections.frequency(arraylist, word) > 1) {
                occurence = Collections.frequency(arraylist, word);
            }
        }return  occurence;

    }
    public static String avg(String a) {
        DecimalFormat d = new DecimalFormat(".00");
        String[] array = a.split(" ");
        double avgLength = (double) a.length() / array.length;
   return d.format(avgLength);
    }
}