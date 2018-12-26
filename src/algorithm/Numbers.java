package algorithm;

import databases.ConnectToSqlDB;

import java.util.List;
import java.util.Random;

/*
 *Created by mrahman on 04/02/2018.
 */
public class Numbers {

	/*
	 * Show all the different kind of sorting algorithm by applying into (num array).
	 * Display the execution time for each sorting.Example in below.
	 *
	 * Use any databases[MongoDB, Oracle or MySql] to store data and retrieve data.
	 *
	 * At the end. After running all the sorting algo, come to a conclusion which one is suitable on given data set.
	 *
	 */

	public static void main(String[] args) throws Exception {
		
		int [] num = new int[1000];//1000000 is taking too much time to add and retrieve data from database
		storeRandomNumbers(num);
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		//Selection Sort
		System.out.println("====>Selection Sort<=====");
		Sort algo = new Sort();
		algo.selectionSort(num);
		long selectionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of "+ num.length + " numbers in Selection Sort take: " + selectionSortExecutionTime + " milli sec");
        connectToSqlDB.insertDataFromArrayToSqlTable(num, "selection_sort", "SortingNumbers");
        List<String> numbers = connectToSqlDB.readDataBase("selection_sort", "SortingNumbers");
        printValue(numbers);
		int n = num.length;
		randomize (num, n);
		//Insertion Sort
		System.out.println("====>Insertion Sort<=====");
		algo.insertionSort(num);
		long insertionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Insertion Sort take: " + insertionSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "insert_sort", "SortingNumbers");
		List<String> number = connectToSqlDB.readDataBase("insert_sort", "SortingNumbers");
		printValue(number);
		randomize (num, n);
		//By following above, Continue for rest of the Sorting Algorithm....
		//Bubble sort
		System.out.println("====>Bubble Sort<=====");
		algo.bubbleSort(num);
		long BuubleSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Bubble Sort take: " + BuubleSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "Bubble_sort", "SortingNumbers");
		List<String> numberB = connectToSqlDB.readDataBase("Bubble_sort", "SortingNumbers");
		printValue(numberB);
		randomize (num, n);
        //Heap sort
		System.out.println("====>Heap Sort<=====");
		algo.heapSort(num);
		long heapSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Heap Sort take: " + heapSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "Heap_sort", "SortingNumbers");
		List<String> numberH = connectToSqlDB.readDataBase("Heap_sort", "SortingNumbers");
		printValue(numberH);
		randomize (num, n);
        //Merge sort
		System.out.println("====>Heap Sort<=====");
		algo.MergeSort(num);
		long mergeSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Merge Sort take: " + mergeSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "Merge_sort", "SortingNumbers");
		List<String> numberM = connectToSqlDB.readDataBase("Merge_sort", "SortingNumbers");
		printValue(numberM);
		randomize (num, n);
        //Bucket sort
		System.out.println("====>Bucket Sort<=====");
		algo.bucketSort(num);
		long bucketSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Bucket Sort take: " + bucketSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "Bucket_sort", "SortingNumbers");
		List<String> numberBu = connectToSqlDB.readDataBase("Bucket_sort", "SortingNumbers");
		printValue(numberBu);
		randomize (num, n);
        //Quick sort
		System.out.println("====>Quick Sort<=====");
		algo.quickSort(num);
		long QuickSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Quick Sort take: " + QuickSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "quick_sort", "SortingNumbers");
		List<String> numberQ = connectToSqlDB.readDataBase("quick_sort", "SortingNumbers");
		printValue(numberQ);
		randomize (num, n);
        //Shell sort
		System.out.println("====>Shell Sort<=====");
		algo.shellSort(num);
		long shellSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Shell Sort take: " + shellSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "Shell_sort", "SortingNumbers");
		List<String> numberS = connectToSqlDB.readDataBase("Shell_sort", "SortingNumbers");
		printValue(numberS);
		randomize (num, n);




		//Come to conclusion about which Sorting Algo is better in given data set.

	}

	public static void storeRandomNumbers(int [] num){
		Random rand = new Random();
		for(int i=0; i<num.length; i++){
			num[i] = rand.nextInt(1000000);
		}
	}

	public static void randomize( int arr[], int n)
	{
		Random r = new Random();
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n-1; i > 0; i--) {
			int j = r.nextInt(i);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	public static void printValue(List<String> array){
		for(String st:array){
			System.out.println(st);
		}
	}
}
