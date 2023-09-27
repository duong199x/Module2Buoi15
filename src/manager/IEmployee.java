package manager;

import model.Employee;

import java.util.ArrayList;

public interface IEmployee<E> {
    public void addEmployee(E e);

    public void deleteEmployee(int id);

    public void editEmployee(int id, E e);

    public int findIndexById(int id);
    public ArrayList<E> showEmployee();
}
