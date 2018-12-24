package string.problems;

import org.testng.Assert;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.
        try {
            Assert.assertEquals(Anagram.anagram("java", "vaja"), true);
            System.out.println("Unit test for anagram is passed");
        } catch (Exception e) {
            System.out.println("Unit test for anagram is failed");
        }
    }
}
