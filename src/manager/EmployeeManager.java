package manager;

import dto.ReadAndWriteEmployee;
import model.Employee;

import java.util.ArrayList;

public class EmployeeManager implements IEmployee<Employee> {
    private ArrayList<Employee> listEmployee;
    private ReadAndWriteEmployee readAndWriteEmployee;

    public EmployeeManager() {
        readAndWriteEmployee = new ReadAndWriteEmployee();
        listEmployee = new ArrayList<>();

    }

    @Override
    public void addEmployee(Employee employee) {
        listEmployee.add(employee);
        readAndWriteEmployee.writeFile(listEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        int index = findIndexById(id);
        listEmployee.remove(index);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        int index = findIndexById(id);
        listEmployee.set(index, employee);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

    public Employee findEmployee(int id) {
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getID() == id) {
                return listEmployee.get(i);
            }
        }
        return null;
    }

    public ArrayList<Employee> showEmployee() {
        return this.listEmployee;
    }

}
