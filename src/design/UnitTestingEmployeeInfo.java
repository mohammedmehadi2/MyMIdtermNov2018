package design;

import org.testng.Assert;

public class UnitTestingEmployeeInfo {
    public static void main(String[] args) {
        //Write Unit Test for all the methods has been implemented in this package.
        EmployeeInfo e1 = new EmployeeInfo();
        e1.setEmployeeID(1);
        e1.setEmployeeAge(2);
        e1.setName("asdf");

        Assert.assertEquals(e1.employeeName(),"asdf","not passed");{
            System.out.println("Unittest 1 passed");
        }
        Assert.assertEquals(e1.employeeage(),2,"not passed");{
            System.out.println("Unittest 2 passed");
        }
        Assert.assertEquals(e1.employeeId(),1,"not passed");{
            System.out.println("Unittest 3 passed");
        }
    }
}
