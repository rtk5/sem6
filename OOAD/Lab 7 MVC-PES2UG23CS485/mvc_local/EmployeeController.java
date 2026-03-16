// Controller Class
public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    // Constructor
    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    // Setters to modify Model data
    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public void setEmployeeSalary(double salary) {
        model.setSalary(salary);
    }

    public void setEmployeeId(int id) {
        model.setId(id);
    }

    // Getters to retrieve Model data
    public String getEmployeeName() {
        return model.getName();
    }

    public double getEmployeeSalary() {
        return model.getSalary();
    }

    public int getEmployeeId() {
        return model.getId();
    }

    // Method to update View
    public void updateView() {
        view.printEmployeeDetails(model.getId(), model.getName(), model.getSalary());
    }
}
