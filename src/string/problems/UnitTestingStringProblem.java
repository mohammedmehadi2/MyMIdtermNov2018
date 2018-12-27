package string.problems;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.
        //Unit test for Anagram
        try {
            Assert.assertEquals(Anagram.anagram("java", "vaja"), true);
            System.out.println("Unit test for anagram is passed");
        } catch (Exception e) {
            System.out.println("Unit test for anagram is failed");
        }
        //Unit Test for permutation
        String expected = " abc acb bac bca cba cab";
        try {
            Assert.assertEquals(Permutation.generatePermutation("abc", 0, 3), expected);
            {
                System.out.println("Unit test for Permutation is passed");
            }
        } catch (Exception e) {
            System.out.println("Unit test for permutation is failed ");
        }
        //unit test for Duplicate words
        int expected3 = 3;
        try {
            Assert.assertEquals(DuplicateWord.occur("Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language"), expected3);
            {
                System.out.println("Unit test for Duplicate is passed");
            }
        } catch (Exception e) {
            System.out.println("Unit test for Duplicate is failed ");
        }
        //unit test for Palindrome
        boolean expected4 = true;
        try {
            Assert.assertEquals(Palindrome.palindromeMethod("MADAM"), expected4);
            {
                System.out.println("Unit test for Palindrome is passed");
            }
        } catch (Exception e) {
            System.out.println("Unit test for Palindrome is failed ");

        }
        Map<Integer, String> expected5 = new HashMap<>();
        expected5.put(10, "biological");
        try {
            Assert.assertEquals(DetermineLargestWord.findTheLargestWord("Human brain is a biological learning machine"), expected5);
            {
                System.out.println("Unit test for DetermineLargestword is passed");
            }
        } catch (Exception e) {
            System.out.println("Unit test for DetermineLargestword is failed ");

        }
    }
}
