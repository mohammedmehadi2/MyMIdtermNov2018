package datastructure;

import databases.ConnectToSqlDB;
import sun.tools.asm.ArrayData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataReader {

	public static void main(String[] args) throws Exception {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class.
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		String textFile = "/Users/mohammedmehadi/Desktop/MidtermNovember2018/src/data/self-driving-car";


		Stack stack = new Stack();
		LinkedList<String> linkedList = new LinkedList<>();
		int count = 0;
		ConnectToSqlDB con = new ConnectToSqlDB();
		FileReader fr = null;
		try {
			fr = new FileReader(textFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BufferedReader q = new BufferedReader(fr);


		String text;
		String total = "";
		System.out.println("==>READING THE FILE<==");
		try {
			while ((text = q.readLine()) != null) {
				System.out.println(text);
				total += text;
				String[] words = text.split(" ");
				for (int i = 0; i < words.length; i++) {
					stack.push(words[i]);

					linkedList.add(words[i]);
				}


				//connecting database

			}
			System.out.println("====================>CONNECT TO DATABASE <==========================");
			con.insertDataFromStringToSqlTable(total, "Datareader", "Clom_Datreader");
		} catch (Exception e) {
			System.out.println("The error is " + e);
		} finally {
			try {
				q.close();
				fr.close();

			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("====================>Retrieving Data from DATABASE <=======================");
		List<String> t = con.readDataBase("Datareader", "Clom_Datreader");
		for (String s : t) {
			System.out.println(s);

		}
		System.out.println("====================>From LinkedList(Fifo) <=======================");


		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i)+" ");


		}
		System.out.println("\n====================>From Stack(Filo) <=======================");


		for (int i=stack.size()-1; i>=0; i--) {
			System.out.print(stack.get(i)+" ");
		}
		System.out.println("\n=============>Peeking , Searching, Popping<=================");

		System.out.println("Peeking stack: "+ stack.peek());
		System.out.println("Searching stack: "+stack.search("steps!"));
		System.out.println("before poping : " +stack);
		System.out.println("Popping stack: "+stack.pop());
		System.out.println("After poping : " +stack);
		System.out.println("Peeking once more to check : "+ stack.peek());



		System.out.println("==============>Retrieving data using for-each loop <================== ");
		for(Object st: linkedList) {
			System.out.print(st+" ");
		}
		System.out.println("\n==========>Retrieving data using while loop <=================");
		while(!stack.empty()){
			System.out.print(stack.pop()+" ");
		}


		System.out.println("\n=====================>Retrieving data using iterator<==================");
		Iterator it = linkedList.iterator();
		while(it.hasNext()) {
			String obj = (String) it.next();
			System.out.print(obj+" ");


	}
}
}

