package algorithm;

import org.testng.Assert;

public class UnitTestSorting {

    /*
      This class is about Unit testing for Sorting Algorithm.
     */
    public static void main(String[] args) {
        int[] unSortedArray = {6, 9, 2, 5, 1, 0, 4};
        int[] sortedArray = {0, 1, 2, 4, 5, 6, 9};
        //Create Sort object
        Sort sort = new Sort();
        //apply unsorted array to selectionSort.
        sort.selectionSort(unSortedArray);
        //verify if the unsorted array is sorted by the selection sort algorithm.
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }


        //Now implement Unit test for rest of the soring algorithm...................below
        //insertion sort
        int[] unSortedArray1 = {6, 9, 2, 5, 1, 0, 4};
        sort.insertionSort(unSortedArray1);
        try {
            Assert.assertEquals(sortedArray, unSortedArray1, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        //Bubble sort
        int[] unSortedArray2 = {6, 9, 2, 5, 1, 0, 4};
        sort.bubbleSort(unSortedArray2);
        try {
            Assert.assertEquals(sortedArray, unSortedArray2, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        //Heap sort
        int[] unSortedArray3 = {6, 9, 2, 5, 1, 0, 4};
        sort.heapSort(unSortedArray3);
        try {
            Assert.assertEquals(sortedArray, unSortedArray3, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        //Bucket sort
        int[] unSortedArray4 = {6, 9, 2, 5, 1, 0, 4};
        sort.bucketSort(unSortedArray4);
        try {
            Assert.assertEquals(sortedArray, unSortedArray4, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        //Merge sort
        int[] unSortedArray5 = {6, 9, 2, 5, 1, 0, 4};
        sort.MergeSort(unSortedArray5);
        try {
            Assert.assertEquals(sortedArray, unSortedArray5, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        //Quick sort
        int[] unSortedArray6 = {6, 9, 2, 5, 1, 0, 4};
        sort.quickSort(unSortedArray6);
        try {
            Assert.assertEquals(sortedArray, unSortedArray6, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        //Shell sort
        int[] unSortedArray7 = {6, 9, 2, 5, 1, 0, 4};
        sort.shellSort(unSortedArray7);
        try {
            Assert.assertEquals(sortedArray, unSortedArray7, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }



    }
}