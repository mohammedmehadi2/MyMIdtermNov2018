package datastructure;

import databases.ConnectToSqlDB;

import java.util.*;

public class UseMap {

	public static void main(String[] args) throws Exception {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */

		List<Integer> atrain = new ArrayList<Integer>();
		atrain.add(42);
		atrain.add(34);

		List<Integer> rtrain = new ArrayList<Integer>();
		rtrain.add(36);
		rtrain.add(23);

		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		map.put("Express Train Stops", atrain);
		map.put("Local Train Stops", rtrain);


		Iterator itr = map.entrySet().iterator();
		System.out.println("Retriveing Data using while loop : ");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Retriveing Data using for each loop : ");
		for (Map.Entry q : map.entrySet()) {
			System.out.println(q.getKey() + " = " + q.getValue());
		}

		ConnectToSqlDB con = new ConnectToSqlDB();
		List list = atrain;

		con.insertDataFromArrayListToSqlTable(list, "tbl_Map", "clm_Mapdata");
		//Read data from  database
		List<String> num = con.readDataBase("tbl_Map", "clm_Mapdata");
		for (String s : num) {
			System.out.println(s);
		}
		List list2 = rtrain;
		con.insertDataFromArrayListToSqlTable(list2, "tbl_Map2", "clm_Mapdata2");
		//Read data from  database
		List<String> num2 = con.readDataBase("tbl_Map2", "clm_Mapdata2");
		for (String s : num2) {
			System.out.println(s);

		}
	}

	}

