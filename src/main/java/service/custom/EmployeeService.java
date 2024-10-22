package service.custom;

import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.ObservableList;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(String id);
    ObservableList<EmployeeEntity> getAllEmployees();
    boolean updateEmployee(Employee employee);
    Employee searchEmployee(String id);
    //ObservableList<String> getEmployeeIds();
}
