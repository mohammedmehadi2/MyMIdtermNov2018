package datastructure;

import databases.ConnectToSqlDB;
import string.problems.Anagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UseArrayList {

	public static void main(String[] args) throws Exception {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */
		ArrayList<Integer> myarray = new ArrayList<>();
		System.out.println("Before adding the arraylist : "+myarray);
		myarray.add(555);
        myarray.add(222);
        myarray.add(111);
        myarray.add(333);
		System.out.println("After adding the arraylist :"+ myarray);


		//peek
		System.out.println("peek element : "+ myarray.get(0));
		//remove
		System.out.println("Before removing: "+myarray);
		myarray.remove(0);
		System.out.println("After removing :"+ myarray);
		//retrieve
		System.out.println("Retrieving from The Arraylist : "+myarray);
		//Using Iterator to retrieve data(for each)
		System.out.print("Retrieving Data by using for each loop :" );
		for (Integer s : myarray){
			System.out.print(" " + s);
		}
		//Using Iterator to retrieve data(while loop)
		System.out.print("\nRetrieving Data by using while loop :" );
		Iterator it = myarray.iterator();
		while (it.hasNext()){
			Integer s = (Integer) it.next();
			System.out.print(" "+s);
		}
     //sorting
		Collections.sort(myarray);
		System.out.println("\nSorted arraylist : "+myarray);
		//inserting data to datbase
		List lst = myarray;
		ConnectToSqlDB con=new ConnectToSqlDB();
		con.insertDataFromArrayListToSqlTable(lst,"tbl_Arraylist","clm_Arraylist");
		//Read data from  database
		List<String> num = con.readDataBase("tbl_Arraylist","clm_Arraylist");
		for (String s : num){
			System.out.println(s);
		}


	}


}
