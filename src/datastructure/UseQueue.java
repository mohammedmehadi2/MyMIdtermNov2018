package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		Queue<String> cars = new LinkedList<>();
		cars.add("Toyota");
		cars.add("Nissan");
		cars.add("BMW");
		cars.add("Tesla");
		cars.add("Bugarti");
		cars.add("Dodge");
		System.out.println("peek : "+cars.peek());
		System.out.println("before removing "+cars);
		System.out.println("remove : "+cars.remove());
		System.out.println("After removing "+cars);
		System.out.println("Before poll : " + cars);
		System.out.println("poll : "+cars.poll());
		System.out.println("After poll : "+cars);
		System.out.print("Using for each loop : ");
		for(String s : cars ){
			System.out.print(" "+s);
		}
		System.out.print("\nUsing while loop : ");
		Iterator it = cars.iterator();
		while(it.hasNext()){
			System.out.print(" "+it.next());
		}

	}

}
