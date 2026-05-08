/**
 *
 * @author shridevisawant
 */

/*
Without DIP, the business layer directly depends on the database 
implementation, which creates tight coupling.

*/

//Data Access Layer
class MySQLDatabase {
    void saveEmployee(String name) {
        System.out.println("Saving employee to MySQL: " + name);
    }
}

//Business Layer (depends on concrete class)
//If we change the database to MongoDB, PostgreSQL,
// or API, we must modify the business layer.
class EmployeeService {

    MySQLDatabase db = new MySQLDatabase();

    void registerEmployee(String name) {
        db.saveEmployee(name);
    }
}


public class BadDIP {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        service.registerEmployee("Rahul");
    }
}