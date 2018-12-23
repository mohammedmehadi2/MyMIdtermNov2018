package math.problems;

/**
 * Created by mrahman on 04/02/18.
 */
public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */
        // Using Iteration
        int q = 5;
        int outcome = 1;
        for (int i = 1; i <= q; i++) {

            outcome = outcome * i;

        }
        System.out.println("The factorial of 5(By using iteration) : " +outcome);
        System.out.println("The factorial of 5(By using recursion) : " + recurs(5));

    }public static int recurs(int q){

        if (q==1){

            return 1;}
        else {

            return q*recurs(q-1);}

    }

}
