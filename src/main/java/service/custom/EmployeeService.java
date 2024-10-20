package service.custom;

import dto.Employee;
import javafx.collections.ObservableList;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(String id);
    ObservableList<Employee> getAll();
    boolean updateEmployee(Employee employee);
    Employee searchEmployee(String id);
    ObservableList<String> getEmployeeIds();
}
