package design;

import databases.ConnectToMongoDB;
import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
	public static void main(String[] args) {
		int no;


		EmployeeInfo employee1 = new EmployeeInfo("Mehadi", 111, 27);
		EmployeeInfo employee2 = new EmployeeInfo("Maruf", 222, 28);
		EmployeeInfo employee3 = new EmployeeInfo("Arif", 333, 28);
		EmployeeInfo employee4 = new EmployeeInfo("Mahmud", 444, 30);
		EmployeeInfo employee5 = new EmployeeInfo("Salma", 555, 29);
		Scanner s = new Scanner(System.in);
		System.out.print("There are 5 employees Information. Type any no between 1 to 5 to get their information.\n Type : ");
		try {
			no = s.nextInt();
			switch (no) {
				case 1:
					System.out.println("This is " + employee1.employeename + ". His age is " + employee1.employeeage + ". His id is " + employee1.employeeId() + ". Our company name is : " + EmployeeInfo.companyName);
					employee1.assignDepartment();
					break;
				case 2:
					System.out.println("This is " + employee2.employeename + ". His age is " + employee2.employeeage + ". His id is " + employee2.employeeId() + ". Our company name is : " + EmployeeInfo.companyName);
					employee2.assignDepartment();
					break;
				case 3:
					System.out.println("This is " + employee3.employeename + ". His age is " + employee3.employeeage + ". His id is " + employee3.employeeId() + ". Our company name is : " + EmployeeInfo.companyName);
					employee1.assignDepartment();
					break;
				case 4:
					System.out.println("This is " + employee4.employeename + ". His age is " + employee4.employeeage + ". His id is " + employee4.employeeId() + ". Our company name is : " + EmployeeInfo.companyName);
					employee1.assignDepartment();
					break;
				case 5:
					System.out.println("This is " + employee5.employeename + ". His age is " + employee5.employeeage + ". His id is " + employee5.employeeId() + ". Our company name is : " + EmployeeInfo.companyName);
					employee1.assignDepartment();
					break;
				default:
					System.out.println("Sorry there is no info related to your number.Our company have only 5 employees. To get their info run again");
			}
		} catch (InputMismatchException e) {
			System.out.println("You didnt type any number.you have to type a number.To check the information pls Run again");
		}
		System.out.println("\nWe have a employee Bonus calculator and a employee pension calculator.Type b to calculate bonus and type p for calculate pension : ");
		Scanner c = new Scanner(System.in);
		String caltype = c.nextLine();
		switch (caltype) {
			case "b":
				try {
					Scanner q = new Scanner(System.in);
					System.out.println("Type Salary amount : ");
					int salary = q.nextInt();
					System.out.println("Type performance percent in number : ");
					int performace = q.nextInt();

					EmployeeInfo.calculateEmployeeBonus(salary, performace);
					break;
				} catch (InputMismatchException e) {
					System.out.println("You have to type number to calculate ");
				}
			case "B":
				try {
					Scanner q = new Scanner(System.in);
					System.out.println("Type Salary amount : ");
					int salary = q.nextInt();
					System.out.println("Type performance percent in number : ");
					int performace = q.nextInt();

					EmployeeInfo.calculateEmployeeBonus(salary, performace);
					break;
				} catch (InputMismatchException e) {
					System.out.println("You have to type number to calculate ");
				}
			case "p":
				try {
					Scanner q = new Scanner(System.in);
					System.out.println("Type Salary amount : ");
					int sal = q.nextInt();
					EmployeeInfo.calculateEmployeePension(sal);
					break;
				} catch (InputMismatchException e) {
					System.out.println("Sorry the input from you is not correct ");
				}
			case "P":
				try {
					Scanner q = new Scanner(System.in);
					System.out.println("Type Salary amount : ");
					int sal = q.nextInt();
					EmployeeInfo.calculateEmployeePension(sal);
					break;
				} catch (InputMismatchException e) {
					System.out.println("Sorry the input from you is not correct ");
				}
			default:
				System.out.println("Sorry You have to type b or p.To Use this programm pls run again");
		}
		employee1.setName("Mehadi");
		employee1.setEmployeeAge(27);
		employee1.setEmployeeID(111);

		employee2.setName("Maruf");
		employee2.setEmployeeAge(28);
		employee2.setEmployeeID(222);

		employee3.setName("Arif");
		employee3.setEmployeeAge(28);
		employee3.setEmployeeID(333);


		List<EmployeeInfo> list = new ArrayList<>();
		list.add(0, employee1);
		list.add(1, employee2);
		list.add(2, employee3);
		list.add(3, employee4);
		list.add(4, employee5);
		List list1 = list;


		ConnectToMongoDB mon = new ConnectToMongoDB();
		mon.insertIntoMongoDBforemp(list1, "List of fortune Employee");


		List<EmployeeInfo> emp = mon.readEmployeeListFromMongoDB("List of fortune Employee");
		for (EmployeeInfo person : emp) {
			System.out.println(person.employeeName() + " " + person.employeeage());


		}

	}
}

