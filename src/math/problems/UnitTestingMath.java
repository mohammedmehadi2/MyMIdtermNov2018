package math.problems;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class UnitTestingMath {
    public static void main(String[] args) {
        //Apply Unit testing into each classes and methods in this package.
        // Unit Testing for Factorial
       try{ Assert.assertEquals(Factorial.itteration(),120);
        Assert.assertEquals(Factorial.recurs(5),120);
        System.out.println("Unit test for Factorial passed ");
       }catch (Exception e){
           System.out.println("Unit test for Factorial failed");
       }
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986));
        try{ Assert.assertEquals(Fibonacci.fibonaccimethod(),expected);

            System.out.println("Unit test for Fibonacci passed ");
       }catch (Exception e){
            System.out.println("Unit test for Fibonacci failed");
        }

    }
}
