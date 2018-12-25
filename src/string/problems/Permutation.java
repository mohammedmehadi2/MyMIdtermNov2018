package string.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrahman on 04/22/17.
 */
public class Permutation {


    public static void main(String[] args) {

        /*
         * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".
         * Write Java program to compute all Permutation of a String
         *
         */
        System.out.println(generatePermutation("abc",0,3));

    }
    public static String swapString(String a, int i, int j) {
        char[] b =a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }static String  q = "";
    public static String generatePermutation(String str, int start, int end)
    {

        if (start == end-1){

          q = (q +" "+str);


        }
        else
        {
            for (int i = start; i < end; i++)
            {

                str = swapString(str,start,i);

                generatePermutation(str,start+1,end);

                str = swapString(str,start,i);

            }
        }
   return q; }
}



