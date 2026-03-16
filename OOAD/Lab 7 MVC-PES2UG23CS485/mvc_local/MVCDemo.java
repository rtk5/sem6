// Main Class
public class MVCDemo {
    public static void main(String[] args) {
        // Create Model
        Employee employee = new Employee(101, "John Doe", 50000);

        // Create View
        EmployeeView view = new EmployeeView();

        // Create Controller and pass Model & View
        EmployeeController controller = new EmployeeController(employee, view);

        // Display Initial Employee Details
        controller.updateView();

        // Modify Employee Data----assumet add to db and ret back from db
        System.out.println("\nUpdating Employee Details...\n");
        controller.setEmployeeName("Jane Doe");
        controller.setEmployeeSalary(60000);

        // Display Updated Employee Details
        controller.updateView();
    }
}
