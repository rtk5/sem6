/**
 *
 * @author shridevisawant
 */

/*
Dependency Inversion Principle says high-level classes should 
depend on interfaces (abstractions) rather than concrete classes.

Abstractions should not depend on details. 
Details should depend on abstractions.
*/

//Introduce an abstraction for the data access layer.
interface EmployeeRepository {
    void saveEmployee(String name);
}

//Data Access Implementations
//MySQL Repository
class MySQLRepository implements EmployeeRepository {

    public void saveEmployee(String name) {
        System.out.println("Saving employee to MySQL: " + name);
    }
}

//MongoDB Repository

class MongoRepository implements EmployeeRepository {

    public void saveEmployee(String name) {
        System.out.println("Saving employee to MongoDB: " + name);
    }
}

//Business Layer Depends on Interface
class EmployeeService {

    private EmployeeRepository repository;

    EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    void registerEmployee(String name) {
        repository.saveEmployee(name);
    }
}

public class DIPDemo {

    public static void main(String[] args) {

        EmployeeRepository repo = new MySQLRepository();
        EmployeeService service = new EmployeeService(repo);

        service.registerEmployee("Rahul");
    }
}