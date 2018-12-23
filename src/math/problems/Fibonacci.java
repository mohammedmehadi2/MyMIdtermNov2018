package math.problems;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
         */
        int [] q = new int[40];

        for (int i = 0;i <40; i ++){

            if (i <2){

                q[i]=i;}
            else {
                q[i]=q[i-2] + q [i -1] ;
            }
        }
        System.out.println("40 Fibonacci numbers : "+Arrays.toString(q));

    }
}