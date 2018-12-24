package math.problems;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {


	public static void main(String[] args) throws Exception {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */


		;
		System.out.println("List of prime numbers between 2 and 1000000 : ");
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 2; i <= 1000000; i++) {
			if (isPrime(i)) {
				System.out.println(i);
				array.add(i);


			}
			;
		}
		List arrrlist = array;


		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		connectToSqlDB.insertDataFromArrayListToSqlTable(arrrlist, "Tbl_PrimeNumber", "Column_PrimeNumber");
		List<String> primeNumber = connectToSqlDB.readDataBase("Tbl_PrimeNumber", "Column_PrimeNumber");
		System.out.println("Data is reading from the Table (tbl_PrimeNumber) and displaying to the console");
		for (String st : primeNumber) {
			System.out.println(st);
		}
	}
		public static boolean isPrime ( int n){
			if (n <= 1) {
				return false;
			}
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}







