package math.problems;

public class FindLowestDifference {
    public static void main(String[] args) {
        /*
         Implement in java.
         Read this below two array. Find the lowest difference between the two array cell.
         The lowest difference between cells is 1
        */
        System.out.println(findlowestmethod());

    }

    public static int findlowestmethod() {
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};
        int lowestNum1 = array1[0];
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] < lowestNum1) {
                lowestNum1 = array1[i];
            }
        }
        int lowestNum2 = array2[0];
        for (int i = 1; i < array2.length; i++) {
            if (array2[i] < lowestNum2) {
                lowestNum2 = array2[i];
            }
        }if (lowestNum1 < lowestNum2){
            return lowestNum1;
        }else {
            return lowestNum2;
        }
    }
}






