package databases;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import design.EmployeeInfo;
import org.bson.Document;
import parser.Student;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mrahman on 09/09/18.
 */

public class ConnectToMongoDB {

    public static MongoDatabase mongoDatabase = null;

    public static MongoDatabase connectToMongoDB() {
        MongoClient mongoClient = new MongoClient();
        mongoDatabase = mongoClient.getDatabase("mehadi");
        System.out.println("Database Connected");

        return mongoDatabase;
    }

    public static String insertIntoToMongoDB(User user){
        String profile = user.getStName();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
        Document document = new Document().append("stName",user.getStName()).append("stID", user.getStID()).
                append("stDOB",user.getStDOB());
        collection.insertOne(document);
        return profile + " has been registered";
    }

    public String insertIntoMongoDB(List<Student> student,String profileName){
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection myCollection = mongoDatabase.getCollection(profileName);
        boolean collectionExists = mongoDatabase.listCollectionNames()
                .into(new ArrayList<String>()).contains(profileName);
        if(collectionExists) {
            myCollection.drop();
        }
        for(int i=0; i<student.size(); i++){
            MongoCollection<Document> collection = mongoDatabase.getCollection(profileName);
            Document document = new Document().append("firstName", student.get(i).getFirstName()).append("lastName",
                    student.get(i).getLastName()).append("score",student.get(i).getScore()).append("id", student.get(i).getId());
            collection.insertOne(document);
        }
        return  "Student has been registered";
    }
    public String insertIntoMongoDBforemp(List<EmployeeInfo> emp, String profileName){
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection myCollection = mongoDatabase.getCollection(profileName);
        boolean collectionExists = mongoDatabase.listCollectionNames()
                .into(new ArrayList<String>()).contains(profileName);
        if(collectionExists) {
            myCollection.drop();
        }
        for(int i=0; i<emp.size(); i++){
            MongoCollection<Document> collection = mongoDatabase.getCollection(profileName);
            Document document = new Document().append("name", emp.get(i).employeeName()).append("Id",
                    emp.get(i).employeeId()).append("age",emp.get(i).employeeage());
            collection.insertOne(document);
        }
        return  "Employee has been registered";
    }
    public  List<EmployeeInfo> readEmployeeListFromMongoDB(String profileName){
        List<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
        EmployeeInfo emp = new EmployeeInfo();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection(profileName);
        BasicDBObject basicDBObject = new BasicDBObject();
        FindIterable<Document> iterable = collection.find(basicDBObject);
        for(Document doc:iterable){
            String Name = (String)doc.get("name");
            emp.setName(Name);
           // int  id = (Integer) doc.get("id");
           // emp.setEmployeeID(id);
            int age = (Integer) doc.get("age");
            emp.setEmployeeAge(age);

            emp = new EmployeeInfo(emp.employeeName(),emp.employeeId(), emp.employeeage());
            list.add(emp);
        }
        return list;
    }

    public  List<User> readUserProfileFromMongoDB(){
        List<User> list = new ArrayList<User>();
        User user = new User();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
        BasicDBObject basicDBObject = new BasicDBObject();
        FindIterable<Document> iterable = collection.find(basicDBObject);
        for(Document doc:iterable){
            String stName = (String)doc.get("stName");
            user.setStName(stName);
            String stID = (String)doc.get("stID");
            user.setStID(stID);
            String stDOB = (String)doc.get("stDOB");
            user.setStID(stDOB);
            user = new User(stName,stID,stDOB);
            list.add(user);
        }
        return list;
    }

    public  List<Student> readStudentListFromMongoDB(String profileName){
        List<Student> list = new ArrayList<Student>();
        Student student = new Student();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection(profileName);
        BasicDBObject basicDBObject = new BasicDBObject();
        FindIterable<Document> iterable = collection.find(basicDBObject);
        for(Document doc:iterable){
            String firstName = (String)doc.get("firstName");
            student.setFirstName(firstName);
            String lastName = (String)doc.get("lastName");
            student.setLastName(lastName);
            String score = (String)doc.get("score");
            student.setScore(score);
            String id = (String) doc.get("id");
            student.setId(id);
            student = new Student(student.getFirstName(),student.getLastName(),student.getScore(),student.getId());
            list.add(student);
        }
        return list;
    }

    public static void main(String[] args){
        ConnectToMongoDB mon=new ConnectToMongoDB();
        mon.connectToMongoDB();

        insertIntoToMongoDB(new User("Naomi Chan", "4493","07-1996"));
        List<User> user = mon.readUserProfileFromMongoDB();
        for(User person:user){
            System.out.println(person.getStName()+ " "+ person.getStID());
        }
    }
}
