package service.custom;

import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.ObservableList;
import service.SuperService;

public interface EmployeeService extends SuperService {
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(String id);
    ObservableList<Employee> getAllEmployees();
    boolean updateEmployee(Employee employee);
    Employee searchEmployee(String id);
    ObservableList<String> getEmployeeIds();
}
