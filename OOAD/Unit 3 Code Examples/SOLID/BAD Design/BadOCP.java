/**
 *
 * @author shridevisawant
 */
/*
If we add a new employee type like ContractEmployee, we must modify this class which violates OCP.
*/

class SalaryCalculator {

    double calculateSalary(String employeeType) {

        if(employeeType.equals("FullTime")) {
            return 50000;
        }
        else if(employeeType.equals("PartTime")) {
            return 20000;
        }

        return 0;
    }
}