package math.problems;

import org.testng.Assert;

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
//        try{ Assert.assertEquals(Fibonacci.fibonaccimethod(),);
//            Assert.assertEquals(Factorial.recurs(5),120);
//            System.out.println("Unit test for Factorial passed ");
//        }catch (Exception e){
//            System.out.println("Unit test for Factorial failed");
//        }

    }
}
