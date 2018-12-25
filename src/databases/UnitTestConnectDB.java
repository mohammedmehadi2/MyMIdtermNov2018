package databases;

public class UnitTestConnectDB {
    public static void main(String[] args) {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        try{ConnectToSqlDB.connectToSqlDatabase();}catch (Exception e)
        {
            System.out.println("The error is : "+ e);}

    }
}
