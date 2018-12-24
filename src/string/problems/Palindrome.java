package string.problems;

public class Palindrome {
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        System.out.println(palindromeMethod("MADAM"));

    }
    public static boolean palindromeMethod(String str){
        StringBuilder q=new StringBuilder(str);
        q.reverse();
        String rev=q.toString();
        if(str.equals(rev)){
            return true;
        }else{
            return false;
        }
    }
}

