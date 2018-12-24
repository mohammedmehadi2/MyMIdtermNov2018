package math.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
         */

        System.out.println(fibonaccimethod());
    }



    public static ArrayList<Integer> fibonaccimethod() {
        int[] fibo = new int[40];
        ArrayList<Integer> arr = new ArrayList<>();


        for (int i = 0; i < 20; i++) {

            if (i < 2) {

                fibo[i] = i;
                arr.add(fibo[i]);

            } else {
                fibo[i] = fibo[i - 2] + fibo[i - 1];
                arr.add(fibo[i]);
            }
        }return arr;
    }
}